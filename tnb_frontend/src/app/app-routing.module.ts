import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CategoryComponent} from "./admin/category/category.component";
import {ClientComponent} from "./admin/client/client.component";
import {LandComponent} from "./admin/land/land.component";
import {TauxComponent} from "./admin/taux/taux.component";
import {TnbComponent} from "./admin/tnb/tnb.component";

const routes: Routes = [
  {
    path: 'tnb',
    children: [
      {path: 'tnb', title: 'TNB', component: TnbComponent},
      {path: 'clients', title: 'Clients', component: ClientComponent},
      {path: 'lands', title: 'Lands', component: LandComponent},
      {path: 'rates', title: 'Rates', component: TauxComponent},
      {path: 'categories', title: 'Categories', component: CategoryComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
