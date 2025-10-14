import { Component, OnInit } from '@angular/core';
import { PoNotificationService, PoTableAction, PoTableColumn } from '@po-ui/ng-components';
import { PontoTuristico } from '../shared/models/pontoTuristico';
import { HttpService } from '../service/http-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-pontos-turisticos',
  templateUrl: './pontos-turisticos.component.html',
  styleUrls: ['./pontos-turisticos.component.css']
})
export class PontosTuristicosComponent implements OnInit {

  lsActions: Array<PoTableAction> = this.carregarActions();
  lsColumns: Array<PoTableColumn> = this.carregarColunas();
  lsPontos: Array<PontoTuristico> = [];

  constructor(
    private httpService: HttpService,
    private poNotification: PoNotificationService,
    private router: Router,
    private activatedRoute: ActivatedRoute

  ) { }

  public ngOnInit(): void {
    this.carregarPontos();
  }

  public carregarActions(): Array<PoTableAction> {
    return [
      {
        label: 'Editar',
        icon: 'po-icon-edit',
        action: (row: PontoTuristico) => { this.navegarParaCadastroPontoTuristico(row.id.toString()) }
      },
      {
        label: 'Excluir',
        icon: 'po-icon-delete',
        action: (row: PontoTuristico) => { this.deletarCadastro(row.id) }
      }
    ];
  }

  public deletarCadastro(id: number): void {
    this.httpService.delete('ponto-turistico/' + id).subscribe({
      next: () => {
        this.poNotification.success('Registro excluido com sucesso!');
        this.carregarPontos();
      },
      error: (error) => {
        this.poNotification.error(error);
      }
    });
  }

  public navegarParaCadastroPontoTuristico(idPonto: string = '') {

    const rota = idPonto ? ['/ponto-turistico', idPonto] : ['/ponto-turistico/novo'];
    this.router.navigate(rota);
  }


  public carregarPontos() {
    this.httpService.get('ponto-turistico').subscribe({

      next: (resposta) => {

        let registros: Array<PontoTuristico> = [];

        resposta.forEach(item => {
          let ponto: PontoTuristico = {
            id: item.id,
            nome: item.nome,
            resumo: item.resumo,
            cidade: item.cidade,
            melhorEstacao: item.melhorEstacao,
            paisId: item.paisId,
            paisNome: item.paisNome,
            comentarios: item.comentario || [],
            comentariosCount: item.comentarios?.length || 0
          };
          registros.push(ponto);
        });

        this.lsPontos = [...registros];
      },
      error: (error) => {
        this.poNotification.error(error);
      }
    });
  }

  public carregarColunas(): Array<PoTableColumn> {
    return [
      { property: 'nome', label: 'Nome' },
      { property: 'resumo', label: 'Resumo' },
      { property: 'cidade', label: 'Cidade' },
      { property: 'melhorEstacao', label: 'Melhor Estação' },
      { property: 'paisNome', label: 'País' },
      { property: 'comentariosCount', label: 'Comentários' }

    ];
  }

}
