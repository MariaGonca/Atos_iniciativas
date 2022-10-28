import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ProfileComponent } from './vistas/profile/profile.component';
import { AppComponent } from './app.component';
import { SearchImagesComponent } from './search-images/search-images.component';
import { HttpClientModule } from '@angular/common/http';
import { InfiniteScrollModule } from 'ngx-infinite-scroll';
import { AgregarTutorialComponent } from './agregar-tutorial/agregar-tutorial.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { ListaTutorialesComponent } from './lista-tutoriales/lista-tutoriales.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { TutorialDetallesComponent } from './tutorial-detalles/tutorial-detalles.component';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { authInterceptorProviders } from '../_helpers/auth.interceptor';
import { MenuUserComponent } from './vistas/menu-user/menu-user.component';
import { MenuTutorComponent } from './vistas/menu-tutor/menu-tutor.component';
import { MenuGestorComponent } from './vistas/menu-gestor/menu-gestor.component';
import { HomeComponent } from './vistas/home/home.component';
import { ReactiveFormsModule } from '@angular/forms';
import { TemasService } from './services/temas.service';
import { ListaIniciativaComponent } from './lista-iniciativa/lista-iniciativa.component';
import { IniciativasService } from './services/iniciativas.service';
import { FormIniciativaComponent } from './form-iniciativa/form-iniciativa.component';
import { NavComponent } from './nav/nav.component';
import { PruebasComponent } from './pruebas/pruebas.component';
import { NuevoTemaComponent } from './nuevo-tema/nuevo-tema.component';
import { CommonModule } from '@angular/common';
import { ListaTemasComponent } from './lista-temas/lista-temas.component';
import { EdicionUserComponent } from './vistas/edicion-user/edicion-user.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchImagesComponent,
    AgregarTutorialComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    HomeComponent,
    ListaTutorialesComponent,
    LoginComponent,
    ProfileComponent,
    RegisterComponent,
    TutorialDetallesComponent,
    MenuUserComponent,
    MenuTutorComponent,
    MenuGestorComponent,
    ListaIniciativaComponent,
    FormIniciativaComponent,
    NavComponent,
    PruebasComponent,
    NuevoTemaComponent,
    ListaTemasComponent,
    EdicionUserComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    InfiniteScrollModule,
    CommonModule
  ],
  providers: [authInterceptorProviders, TemasService, IniciativasService],
  bootstrap: [AppComponent]
})
export class AppModule { }
