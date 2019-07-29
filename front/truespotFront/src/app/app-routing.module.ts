import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateUserComponent} from "./components/user/create-user/create-user.component";
import {ViewProfilComponent} from "./components/user/view-profil/view-profil.component";
import {CreateAreaComponent} from "./components/area/create-area/create-area.component";
import {CreateRoadComponent} from "./components/road/create-road/create-road.component";
import {CreateTopoComponent} from "./components/topo/create-topo/create-topo.component";
import {SignInComponent} from "./components/auth/sign-in/sign-in.component";
import {LogoutComponent} from "./components/auth/logout/logout.component";
import {CreateSpotComponent} from "./components/spot/create-spot/create-spot.component";
import {HomeComponent} from "./components/home/home.component";



const routes: Routes = [
  {path: 'createUser', component: CreateUserComponent},
  {path: 'view-profil', component: ViewProfilComponent},
  {path: 'createArea', component: CreateAreaComponent},
  {path: 'createSpot', component: CreateSpotComponent},
  {path: 'createRoad', component: CreateRoadComponent},
  {path: 'createTopo', component:CreateTopoComponent},
  {path: 'sign-in', component: SignInComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'home', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {


}
