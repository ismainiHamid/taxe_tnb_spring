import {Component, OnInit} from '@angular/core';
import {Land, LandComponent} from "../land.component";
import {LandService} from "../land.service";
import {NgForm} from "@angular/forms";
import {ClientService} from "../../client/client.service";
import {CategoryService} from "../../category/category.service";
import {Client} from "../../client/client.component";
import {Category} from "../../category/category.component";

@Component({
  selector: 'app-save-land',
  templateUrl: './save-land.component.html',
  styleUrls: ['./save-land.component.css']
})
export class SaveLandComponent implements OnInit {
  public land: Land;
  public clients: Client[] = [];
  public categories: Category[] = [];

  constructor(private landService: LandService, private landComponent: LandComponent, private clientService: ClientService, private categoryService: CategoryService) {
    this.land = new Land();
  }

  public ngOnInit(): void {
    this.findAllClients();
    this.findAllCategories()
  }

  public save(ngForm: NgForm) {
    this.landService.save(this.land).subscribe(result => {
      this.landComponent.findAll();
      ngForm.resetForm();
    });
  }


  public findAllClients() {
    this.clientService.findAll().subscribe(data => {
      this.clients = data;
    });
  }

  public findAllCategories() {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    });
  }
}
