import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestUserComponent } from './test-user/test-user.component';
import {TestService} from "./services/test/test.service";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { CreateUserComponent } from './components/user/create-user/create-user.component';
import { ViewProfileComponent } from './components/user/view-profile/view-profile.component';
import { NavigationComponent } from './components/gui/navigation/navigation.component';
import { HeaderComponent } from './components/gui/header/header.component';
import { FooterComponent } from './components/gui/footer/footer.component';
import { ViewListUsersComponent } from './components/user/view-list-users/view-list-users.component';
import { CreateTopoComponent } from './components/topo/create-topo/create-topo.component';
import { ViewTopoComponent } from './components/topo/view-topo/view-topo.component';
import { ViewListTopoComponent } from './components/topo/view-list-topo/view-list-topo.component';
import { CreateSpotComponent } from './components/spot/create-spot/create-spot.component';
import { ViewSpotComponent } from './components/spot/view-spot/view-spot.component';
import { CreateRoadComponent } from './components/road/create-road/create-road.component';
import { ViewRoadComponent } from './components/road/view-road/view-road.component';
import { ViewListRoadComponent } from './components/road/view-list-road/view-list-road.component';
import { ViewListDepartmentComponent } from './components/department/view-list-department/view-list-department.component';
import { SignInComponent } from './components/auth/sign-in/sign-in.component';
import { CreateAreaComponent } from './components/area/create-area/create-area.component';
import { ViewAreaComponent } from './components/area/view-area/view-area.component';
import { ViewListAreaComponent } from './components/area/view-list-area/view-list-area.component';

@NgModule({
  declarations: [
    AppComponent,
    TestUserComponent,
    CreateUserComponent,
    ViewProfileComponent,
    NavigationComponent,
    HeaderComponent,
    FooterComponent,
    ViewListUsersComponent,
    CreateTopoComponent,
    ViewTopoComponent,
    ViewListTopoComponent,
    CreateSpotComponent,
    ViewSpotComponent,
    CreateRoadComponent,
    ViewRoadComponent,
    ViewListRoadComponent,
    ViewListDepartmentComponent,
    SignInComponent,
    CreateAreaComponent,
    ViewAreaComponent,
    ViewListAreaComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [TestService],
  bootstrap: [AppComponent]
})
export class AppModule {

}
