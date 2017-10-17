import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { Component, NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
// tslint:disable-next-line:quotemark
import { MaterializeModule } from "angular2-materialize";
import { TareasComponent } from './tareas/tareas.component';
import { ProcesosComponent } from './procesos/procesos.component';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { LoginComponent } from './login/login.component';

export const appRoutes: Routes = [
  {path: '' , component: TareasComponent},
  { path: 'procesos', component: ProcesosComponent },
  { path: 'usuarios', component: UsuariosComponent },
  { path: 'tareas', component: TareasComponent },
  {path: 'app' , component: AppComponent},
  {path: 'login', component: LoginComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    TareasComponent,
    ProcesosComponent,
    UsuariosComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    MaterializeModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [NavbarComponent]
})
export class AppModule { }
