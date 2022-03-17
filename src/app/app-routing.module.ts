import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeUiComponent } from './home-ui/home-ui.component';
import { ListClientComponent } from './list-client/list-client.component';
import { AddClientComponent } from './add-client/add-client.component';
import { ModClientComponent } from './mod-client/mod-client.component';

const routes: Routes = [
  {
    path: '', pathMatch:"full", redirectTo:"clients/home",
  },
  { 
    path: 'clients/home',
    component: HomeUiComponent
  },
  { 
    path: 'clients/insert',
    component: AddClientComponent
  },
  {
    path: "clients/list",
    component: ListClientComponent
  },
  {
    path: "clients/delete/:clientId", component: ListClientComponent
  },
  {
    path: "clients/update/:clientId", component: ModClientComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
