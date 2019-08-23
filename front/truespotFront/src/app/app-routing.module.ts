import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CreateTopoComponent} from "./components/topo/create-topo/create-topo.component";
import {SignInComponent} from "./components/auth/sign-in/sign-in.component";
import {LogoutComponent} from "./components/auth/logout/logout.component";
import {HomeComponent} from "./components/home/home.component";
import {ViewTopoComponent} from "./components/topo/view-topo/view-topo.component";
import {CreateAreaComponent} from "./components/area/create-area/create-area.component";
import {CreateRoadComponent} from "./components/road/create-road/create-road.component";
import {CreateUserComponent} from "./components/user/create-user/create-user.component";
import {ViewMyprofilComponent} from "./components/user/view-myprofil/view-myprofil.component";

import {ViewListTopoComponent} from "./components/topo/view-list-topo/view-list-topo.component";
import {ViewMylistTopoComponent} from "./components/topo/view-mylist-topo/view-mylist-topo.component";
import {UpdateRoadComponent} from "./components/road/update-road/update-road.component";
import {UdapteTopoComponent} from "./components/topo/udapte-topo/udapte-topo.component";
import {UpdateUserComponent} from "./components/user/update-user/update-user.component";
import {ViewUserprofilComponent} from "./components/user/view-userprofil/view-userprofil.component";
import {ViewListUsersComponent} from "./components/user/view-list-users/view-list-users.component";



const appRoutes: Routes = [
  {path: 'sign-in', component: SignInComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'home', component: HomeComponent},

  {path: 'createUser', component: CreateUserComponent},
  {path: 'updateUser', component:UpdateUserComponent},
  {path: 'myprofil', component: ViewMyprofilComponent},
  {path: 'list-user', component: ViewListUsersComponent},
  {path: 'view-UserProfil', component: ViewUserprofilComponent},

  {path: 'createArea', component: CreateAreaComponent},


  {path: 'createRoad', component: CreateRoadComponent},
  {path: 'updateRoad', component: UpdateRoadComponent},

  {path: 'createTopo', component:CreateTopoComponent},
  {path: 'updateTopo', component: UdapteTopoComponent},
  {path: 'list-topo', component: ViewListTopoComponent},
  {path: 'list-myTopos', component: ViewMylistTopoComponent},
  {path: 'view-topo', component: ViewTopoComponent},





  {
    path: 'topo',
    children: [
      {
        path: 'add-topo',
        component: CreateTopoComponent,
      },
      {
        path: 'list-topo',
        component: CreateTopoComponent,
      },
      {
        path: 'view-topo/:idTopo',
        component: ViewTopoComponent,
      },
      {
        path: 'area',
        children: [
          {
            path: 'add-area/:idTopo',
            component: CreateAreaComponent,
          },
        ]
      },
      {
        path: 'road',
        children: [
          {
            path: 'add-road/:idArea',
            component: CreateRoadComponent,
          },
        ]
      },
    ]
  },

  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },

];



@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {


}
