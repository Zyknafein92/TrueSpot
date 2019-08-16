import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { CreateUserComponent } from './components/user/create-user/create-user.component';
import { ViewProfilComponent } from './components/user/view-profil/view-profil.component';
import { ViewListUsersComponent } from './components/user/view-list-users/view-list-users.component';
import { CreateTopoComponent } from './components/topo/create-topo/create-topo.component';
import { ViewTopoComponent } from './components/topo/view-topo/view-topo.component';
import { ViewListTopoComponent } from './components/topo/view-list-topo/view-list-topo.component';
import { CreateRoadComponent } from './components/road/create-road/create-road.component';
import { ViewRoadComponent } from './components/road/view-road/view-road.component';
import { ViewListRoadComponent } from './components/road/view-list-road/view-list-road.component';
import { SignInComponent } from './components/auth/sign-in/sign-in.component';
import { CreateAreaComponent } from './components/area/create-area/create-area.component';
import { ViewAreaComponent } from './components/area/view-area/view-area.component';
import { ViewListAreaComponent } from './components/area/view-list-area/view-list-area.component';
import { LogoutComponent } from './components/auth/logout/logout.component';
import { HomeComponent } from './components/home/home.component';
import {httpInterceptorProviders} from "./services/auth/auth-interceptor";

@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    ViewProfilComponent,
    ViewListUsersComponent,
    CreateTopoComponent,
    ViewTopoComponent,
    ViewListTopoComponent,
    CreateRoadComponent,
    ViewRoadComponent,
    ViewListRoadComponent,
    SignInComponent,
    CreateAreaComponent,
    ViewAreaComponent,
    ViewListAreaComponent,
    LogoutComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule {

}
