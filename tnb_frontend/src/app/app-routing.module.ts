import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from "./admin/admin.component";
import {CategoryComponent} from "./admin/category/category.component";
import {ClientComponent} from "./admin/client/client.component";
import {LandComponent} from "./admin/land/land.component";

const routes: Routes = [
  {
    path: 'tnb',
    children: [
      {path: 'categories', title: 'Categories', component: CategoryComponent},
      {path: 'clients', title: 'Clients', component: ClientComponent},
      {path: 'lands', title: 'Lands', component: LandComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
