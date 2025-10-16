import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PoNotificationService } from '@po-ui/ng-components';
import { HttpService } from 'src/app/service/http-service.service';
import { NovoPais } from 'src/app/shared/models/pais';
import { triggerFormValidators } from 'src/app/shared/util';

@Component({
  selector: 'app-cadastro-paises',
  templateUrl: './cadastro-paises.component.html',
  styleUrls: ['./cadastro-paises.component.css']
})
export class CadastroPaisesComponent implements OnInit {

  idPais: number | null = null;
  formPais: FormGroup;
  title: string = "Novo cadastro de País";

  constructor(private formBuilder: FormBuilder,
    private poNotification: PoNotificationService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpService
  ) {

    this.formPais = this.formBuilder.group({
      nome: ['', Validators.compose([Validators.required])],
      sigla: ['', Validators.compose([Validators.required])],
      continente: ['', Validators.compose([Validators.required])],
      ddi: [, Validators.compose([Validators.required])]
    })
  }

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    this.idPais = idParam ? Number(idParam.trim()) : null;


    if (this.idPais !== null) {
      this.title = "Alteração do País";
      this.buscaDadosPais();
    }
  }

  salvar() {
    if (this.validarRegistro()) {
      if (this.idPais !== null) {
        this.enviarPut();
      } else {
        this.enviarPost();
      }
    } else {
      this.poNotification.error("Preencha todos os campos antes de salvar as alterações!");
    }
  }


  validarRegistro(): boolean {
    return this.formPais.valid;
  }

  enviarPost(): void {
    if (this.formPais.valid) {
      const { nome, sigla, continente, ddi } = this.formPais.value;

      const paisParaCriar: NovoPais = {
        nome: nome.trim(),
        sigla: sigla.toUpperCase(),
        continente,
        ddi: Number(ddi)
      };

      this.http.post('pais', paisParaCriar).subscribe({
        next: () => {
          this.poNotification.success('País criado com sucesso!');
          this.voltar();
        },
        error: (error) => {
          this.poNotification.error('Erro ao criar novo país: ' + error.message);
        }
      });

    }
  }


  enviarPut() {
    this.http.put('pais/' + this.idPais, this.formPais.value).subscribe({
      next: () => {
        this.poNotification.success("Registro atualizado com sucesso!");
        this.voltar();
      },
      error: (erro) => {
        this.poNotification.error(erro)
      },
    })
  }

  voltar() {
    this.router.navigate(['/pais'])
  }

  buscaDadosPais() {
    this.http.get('pais/' + this.idPais).subscribe({
      next: (resposta) => {
        this.formPais.patchValue({
          nome: resposta.nome,
          sigla: resposta.sigla,
          continente: resposta.continente,
          ddi: resposta.ddi
        })
      },
      error: (erro) => {
        this.poNotification.error(erro)
      }
    })
  }
}
