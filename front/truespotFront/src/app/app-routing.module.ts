import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateUserComponent} from "./components/user/create-user/create-user.component";
import {ViewProfilComponent} from "./components/user/view-profil/view-profil.component";
import {CreateAreaComponent} from "./components/area/create-area/create-area.component";
import {CreateRoadComponent} from "./components/road/create-road/create-road.component";
import {CreateTopoComponent} from "./components/topo/create-topo/create-topo.component";
import {SignInComponent} from "./components/auth/sign-in/sign-in.component";
import {LogoutComponent} from "./components/auth/logout/logout.component";
import {AuthGuardService} from "./services/auth-gaurd/auth-gaurd.service";


const routes: Routes = [
  {path: 'createUser', component: CreateUserComponent},
  {path: 'view-profil', component: ViewProfilComponent,canActivate:[AuthGuardService]},
  {path: 'createArea', component: CreateAreaComponent, canActivate:[AuthGuardService]},
  {path: 'createRoad', component: CreateRoadComponent, canActivate:[AuthGuardService]},
  {path: 'createTopo', component:CreateTopoComponent,  canActivate:[AuthGuardService]},
  {path: 'sign-in', component: SignInComponent},
  {path: 'logout', component: LogoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {


}
