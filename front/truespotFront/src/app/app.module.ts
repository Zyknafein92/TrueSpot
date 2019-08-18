import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { CreateUserComponent } from './components/user/create-user/create-user.component';
import { ViewMyprofilComponent } from './components/user/view-myprofil/view-myprofil.component';
import { ViewListUsersComponent } from './components/user/view-list-users/view-list-users.component';
import { CreateTopoComponent } from './components/topo/create-topo/create-topo.component';
import { ViewTopoComponent } from './components/topo/view-topo/view-topo.component';
import { ViewListTopoComponent } from './components/topo/view-list-topo/view-list-topo.component';
import { CreateRoadComponent } from './components/road/create-road/create-road.component';
import { SignInComponent } from './components/auth/sign-in/sign-in.component';
import { CreateAreaComponent } from './components/area/create-area/create-area.component';
import { LogoutComponent } from './components/auth/logout/logout.component';
import { HomeComponent } from './components/home/home.component';
import {httpInterceptorProviders} from "./services/auth/auth-interceptor";
import { UdapteTopoComponent } from './components/topo/udapte-topo/udapte-topo.component';
import { UpdateAreaComponent } from './components/area/update-area/update-area.component';
import { UpdateRoadComponent } from './components/road/update-road/update-road.component';
import { UpdateUserComponent } from './components/user/update-user/update-user.component';
import { ViewUserprofilComponent } from './components/user/view-userprofil/view-userprofil.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    ViewMyprofilComponent,
    ViewListUsersComponent,
    CreateTopoComponent,
    ViewTopoComponent,
    ViewListTopoComponent,
    CreateRoadComponent,
    SignInComponent,
    CreateAreaComponent,
    LogoutComponent,
    HomeComponent,
    UdapteTopoComponent,
    UpdateAreaComponent,
    UpdateRoadComponent,
    UpdateUserComponent,
    ViewUserprofilComponent,
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
