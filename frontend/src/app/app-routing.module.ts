import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroComentarioComponent } from './comentarios/cadastro-comentario/cadastro-comentario.component';
import { CadastroPaisesComponent } from './paises/cadastro-paises/cadastro-paises.component';
import { PaisesComponent } from './paises/paises.component';
import { CadastroPontosTuristicosComponent } from './pontos-turisticos/cadastro-pontos-turisticos/cadastro-pontos-turisticos.component';
import { PontosTuristicosComponent } from './pontos-turisticos/pontos-turisticos.component';

const routes: Routes = [
  {
    path: 'pais',
    children: [
      { path: '', component: PaisesComponent },
      { path: 'novo', component: CadastroPaisesComponent },
      { path: ':id', component: CadastroPaisesComponent }
    ]
  },
  {
    path: 'ponto-turistico',
    children: [
      { path: '', component: PontosTuristicosComponent },
      { path: 'novo', component: CadastroPontosTuristicosComponent },
      { path: ':id', component: CadastroPontosTuristicosComponent },
      { path: ':id/comentario', component: CadastroComentarioComponent },
      { path: ':id/comentario/:idComentario', component: CadastroComentarioComponent }
    ]
  },
  { path: '**', redirectTo: 'pais' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

