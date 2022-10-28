import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { ListaIniciativaComponent } from './lista-iniciativa/lista-iniciativa.component';
import { FormIniciativaComponent } from './form-iniciativa/form-iniciativa.component';
import { HomeComponent } from './vistas/home/home.component';
import { PruebasComponent } from './pruebas/pruebas.component';
import { ListaTemasComponent } from './lista-temas/lista-temas.component';
import { NuevoTemaComponent } from './nuevo-tema/nuevo-tema.component';
import { EdicionUserComponent } from './vistas/edicion-user/edicion-user.component';
const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'edicion/:id', component: EdicionUserComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'pruebas', component: PruebasComponent },
  { path: 'agretema', component: NuevoTemaComponent },
  { path: 'listaTemas', component: ListaTemasComponent },
  {path: 'listaTemas/agretema/:idTema', component: NuevoTemaComponent},
  // { path: 'tutoriales', component: ListaTutorialesComponent },
  // { path: 'tutoriales/:id', component: TutorialDetallesComponent },
  // { path: 'agregar', component: AgregarTutorialComponent },
  { path: 'listaIniciativas', component: ListaIniciativaComponent },
  { path: 'listaIniciativas/form', component: FormIniciativaComponent },
  { path: 'listaIniciativas/form/:idIniciativa', component: FormIniciativaComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


