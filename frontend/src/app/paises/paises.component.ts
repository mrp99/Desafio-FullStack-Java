import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService, PoTableAction, PoTableColumn } from '@po-ui/ng-components';
import { HttpService } from '../service/http-service.service';
import { Pais } from '../shared/models/pais';

@Component({
  selector: 'app-paises',
  templateUrl: './paises.component.html',
  styleUrls: ['./paises.component.css']
})
export class PaisesComponent implements OnInit {

  lsActions: Array<PoTableAction> = this.carregarActions();
  lsColumns: Array<PoTableColumn> = this.carregarColunas();
  lsPaises: Array<Pais> = [];

  constructor(
    private httpService: HttpService,
    private poNotification: PoNotificationService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.carregarPaises()
  }

  carregarActions(): Array<PoTableAction> {
    return [
      {
        label: 'Editar',
        icon: 'po-icon-edit',
        action: (row: Pais) => { this.navegarParaCadastro(row.id.toString()) }
      },
      {
        label: 'Excluir',
        icon: 'po-icon-delete',
        action: (row: Pais) => { this.deletarCadastro(row.id.toString()) }
      }
    ]
  }


  deletarCadastro(id: string): void {
    this.httpService.delete('pais/' + id).subscribe({
      next: () => {
        this.poNotification.success('Registro excluido com sucesso!');
        this.carregarPaises();
      },
      error: (error) => {
        this.poNotification.error(error);
      }
    })
  }

  navegarParaCadastro(codigoPais: string = "") {
    const rota = codigoPais ? ['/pais', codigoPais] : ['/pais/novo'];
    this.router.navigate(rota);
  }

  carregarPaises() {
    return this.httpService.get('pais').subscribe({
      next: (resposta) => {
        let registros: Array<Pais> = []
        resposta.forEach(item => {
          let novoPais: Pais = {
            id: item.id,
            nome: item.nome,
            sigla: item.sigla,
            continente: item.continente,
            ddi: item.ddi
          }
          registros.push(novoPais);
        });

        this.lsPaises = [...registros]
      }
    })
  }

  carregarColunas(): Array<PoTableColumn> {
    return [
      {
        property: 'ddi',
        label: 'DDI'
      },
      {
        property: 'nome',
        label: 'Nome',
      },
      {
        property: 'sigla',
        label: 'Sigla'
      },
      {
        property: 'continente',
        label: 'Continente'
      }
    ]
  }
}

