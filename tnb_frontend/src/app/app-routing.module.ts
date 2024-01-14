import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CategoryComponent} from "./admin/category/category.component";
import {ClientComponent} from "./admin/client/client.component";
import {LandComponent} from "./admin/land/land.component";
import {TnbComponent} from "./admin/tnb/tnb.component";
import {RateComponent} from "./admin/rate/rate.component";

const routes: Routes = [
  {
    path: 'tnb',
    children: [
      {path: 'tnb', title: 'TNB', component: TnbComponent},
      {path: 'clients', title: 'Clients', component: ClientComponent},
      {path: 'lands', title: 'Lands', component: LandComponent},
      {path: 'rates', title: 'Rates', component: RateComponent},
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
