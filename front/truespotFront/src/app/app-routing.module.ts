import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateUserComponent} from "./components/user/create-user/create-user.component";
import {ViewProfilComponent} from "./components/user/view-profil/view-profil.component";
import {CreateAreaComponent} from "./components/area/create-area/create-area.component";
import {CreateRoadComponent} from "./components/road/create-road/create-road.component";
import {CreateTopoComponent} from "./components/topo/create-topo/create-topo.component";

const routes: Routes = [
  {path: 'createUser', component: CreateUserComponent},
  {path: 'view-profil', component: ViewProfilComponent},
  {path: 'createArea', component: CreateAreaComponent},
  {path: 'createRoad', component: CreateRoadComponent},
  {path: 'createTopo', component:CreateTopoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {


}
