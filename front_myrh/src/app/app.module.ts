import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeCompComponent } from './home-comp/home-comp.component';
import { LoginCompComponent } from './login-comp/login-comp.component';
import { AgentCompComponent } from './agent-comp/agent-comp.component';
import { RegisterCompComponent } from './register-comp/register-comp.component';
import { AppRoutingModule } from './app-routing.module';
import { OffreComponent } from './offre/offre.component';
import { OffresComponent } from './offres/offres.component';
import {RouterOutlet} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { EntreComponent } from './entre/entre.component';
import { DashComponent } from './dash/dash.component';
import { ErrorComponent } from './error/error.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeCompComponent,
    LoginCompComponent,
    AgentCompComponent,
    RegisterCompComponent,
    OffreComponent,
    OffresComponent,
    EntreComponent,
    DashComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterOutlet,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
