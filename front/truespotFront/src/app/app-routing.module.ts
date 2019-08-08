import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CreateTopoComponent} from "./components/topo/create-topo/create-topo.component";
import {SignInComponent} from "./components/auth/sign-in/sign-in.component";
import {LogoutComponent} from "./components/auth/logout/logout.component";
import {HomeComponent} from "./components/home/home.component";
import {ViewTopoComponent} from "./components/topo/view-topo/view-topo.component";


const appRoutes: Routes = [
  {path: 'sign-in', component: SignInComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'home', component: HomeComponent},
  {
    path: 'topo',
    children: [
      {
        path: 'ajout-topo',
        component: CreateTopoComponent,
      },
      {
        path: 'view-topo/:idTopo',
        component: ViewTopoComponent,
      }
    ]
  },
  {
    path: '',
    redirectTo: '/topo/ajout-topo',
    pathMatch: 'full'
  }

];

/*{path: 'createUser', component: CreateUserComponent},
 {path: 'view-profil', component: ViewProfilComponent},
 {path: 'createArea', component: CreateAreaComponent},
 {path: 'createSpot', component: CreateSpotComponent},
 {path: 'createRoad', component: CreateRoadComponent},
 {path: 'createTopo', component:CreateTopoComponent},
 {path: 'sign-in', component: SignInComponent},
 {path: 'logout', component: LogoutComponent},
 {path: 'home', component: HomeComponent}*/


@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {


}
