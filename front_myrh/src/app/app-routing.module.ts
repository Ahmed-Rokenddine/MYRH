import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HomeCompComponent} from "./home-comp/home-comp.component";
import {RouterModule, Routes} from "@angular/router";
import {OffresComponent} from "./offres/offres.component";
import {OffreComponent} from "./offre/offre.component";


const routes: Routes = [
  {path:"",redirectTo:"Welcome",pathMatch:"full"},
  {
    path: 'Welcome',
    component: HomeCompComponent
  },
  {
    path: 'Offres',
    component: OffresComponent
  },
  { path: 'Offres/:id', component: OffreComponent },
];
@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
