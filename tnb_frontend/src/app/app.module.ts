import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import { AdminComponent } from './admin/admin.component';
import { CategoryComponent } from './admin/category/category.component';
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatInputModule} from "@angular/material/input";
import {HttpClientModule} from "@angular/common/http";
import {MatButtonModule} from "@angular/material/button";
import {FormsModule} from "@angular/forms";
import { ClientComponent } from './admin/client/client.component';
import { LandComponent } from './admin/land/land.component';
import { TnbComponent } from './admin/tnb/tnb.component';
import {RateComponent} from "./admin/rate/rate.component";
import { SaveCategoryComponent } from './admin/category/save-category/save-category.component';
import { SaveClientComponent } from './admin/client/save-client/save-client.component';
import { SaveLandComponent } from './admin/land/save-land/save-land.component';
import { SaveRateComponent } from './admin/rate/save-rate/save-rate.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    CategoryComponent,
    ClientComponent,
    LandComponent,
    TnbComponent,
    RateComponent,
    SaveCategoryComponent,
    SaveClientComponent,
    SaveLandComponent,
    SaveRateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    MatTableModule,
    MatPaginatorModule,
    MatInputModule,
    HttpClientModule,
    MatButtonModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
