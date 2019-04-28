import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CreateUserComponent} from "./components/user/create-user/create-user.component";

const routes: Routes = [
  {path: 'createUser', component: CreateUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {


}
