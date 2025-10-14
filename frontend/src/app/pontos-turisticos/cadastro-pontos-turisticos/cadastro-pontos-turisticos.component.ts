import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService, PoSelectOption } from '@po-ui/ng-components';
import { HttpService } from 'src/app/service/http-service.service';
import { Estacoes } from 'src/app/shared/enums/estacoes';
import { NovoPontoTuristico } from 'src/app/shared/models/pontoTuristico';

@Component({
  selector: 'app-cadastro-pontos-turisticos',
  templateUrl: './cadastro-pontos-turisticos.component.html',
  styleUrls: ['./cadastro-pontos-turisticos.component.css']
})
export class CadastroPontosTuristicosComponent implements OnInit {

  title = 'Cadastro de Ponto Turístico';
  formPonto: FormGroup;
  idPonto: number | null = null;
  listaDePaises: PoSelectOption[] = [];

  constructor(
    private fb: FormBuilder,
    private poNotification: PoNotificationService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpService
  ) { }

  ngOnInit(): void {
    this.idPonto = Number(this.route.snapshot.paramMap.get('id')) || null;

    this.initForm();
    this.listaDePaises = this.getListaDePaises();


    if (this.idPonto) {
      this.carregarPontoTuristico();
      this.title = 'Edição de Ponto Turístico';
    }

  }

  private initForm(): void {
    this.formPonto = this.fb.group({
      nome: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
      resumo: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      cidade: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]],
      melhorEstacao: [null],
      paisId: [null, [Validators.required, Validators.min(1)]]
    });
  }

  public getListaDePaises(): PoSelectOption[] {
    return [
      { label: 'Brasil', value: 1 },
      { label: 'Argentina', value: 2 },
      { label: 'Chile', value: 3 }
    ];
  }

  public getListaEstacoes(): PoSelectOption[] {
    return Object.values(Estacoes).map(estacao => ({
      label: this.formatarLabel(estacao),
      value: estacao
    }));
  }

  private formatarLabel(valor: string): string {
    const mapa: { [key: string]: string } = {
      VERAO: 'Verão',
      OUTONO: 'Outono',
      INVERNO: 'Inverno',
      PRIMAVERA: 'Primavera'
    };
    return mapa[valor] || valor;
  }

  private carregarPontoTuristico(): void {
    this.http.get(`ponto-turistico/${this.idPonto}`).subscribe({
      next: (res: any) => this.formPonto.patchValue(res),
      error: (error: unknown) => this.exibirErro('Erro ao carregar ponto turístico', error)
    });
  }

  private carregarPaises(): void {
    this.http.get('pais').subscribe({
      next: (res: any) => {
        this.listaDePaises = res.map((pais: any) => ({
          label: pais.nome,
          value: pais.id
        }));
      },
      error: (error: unknown) => this.exibirErro('Erro ao carregar lista de países', error)
    });
  }


  public salvar(): void {
    if (this.validarRegistro()) {
      if (this.idPonto !== null) {
        this.enviarPut();
      } else {
        this.enviarPost();
      }
    } else {
      this.poNotification.warning('Formulário inválido. Verifique os campos.');
    }
  }

  private validarRegistro(): boolean {
    if (this.formPonto.valid) {
      return true;
    } else {
      this.formPonto.markAllAsTouched();
      return false;
    }
  }

  private enviarPost(): void {
    const { nome, resumo, cidade, melhorEstacao, paisId } = this.formPonto.value;

    const novoPonto: NovoPontoTuristico = {
      nome: nome.trim(),
      cidade: cidade.trim(),
      resumo: resumo.trim(),
      melhorEstacao,
      paisId: Number(paisId)
    }

    this.http.post('ponto-turistico', novoPonto).subscribe({
      next: () => {
        this.poNotification.success('Ponto turístico cadastrado com sucesso!');
        this.voltar();
      },
      error: (error: unknown) => this.exibirErro('Erro ao cadastrar ponto turístico', error)
    });
  }

  private enviarPut(): void {
    this.http.put(`ponto-turistico/${this.idPonto}`, this.formPonto.value).subscribe({
      next: () => {
        this.poNotification.success('Ponto turístico atualizado com sucesso!');
        this.voltar();
      },
      error: (error: unknown) => this.exibirErro('Erro ao atualizar ponto turístico', error)
    });
  }

  private exibirErro(contexto: string, error: unknown): void {
    const mensagem = error instanceof Error ? error.message : String(error);
    this.poNotification.error(`${contexto}: ${mensagem}`);
  }

  public voltar(): void {
    this.router.navigate(['/pontos-turisticos']);
  }
}
