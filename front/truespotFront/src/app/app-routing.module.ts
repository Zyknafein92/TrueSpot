import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateUserComponent} from "./components/user/create-user/create-user.component";
import {ViewProfilComponent} from "./components/user/view-profil/view-profil.component";

const routes: Routes = [
  {path: 'createUser', component: CreateUserComponent},
  {path: 'view-profil', component: ViewProfilComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {


}
