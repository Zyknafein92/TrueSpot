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

@NgModule({
  declarations: [
    AppComponent,
    TestUserComponent,
    CreateUserComponent,
    ViewProfileComponent,
    NavigationComponent,
    HeaderComponent,
    FooterComponent,

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
