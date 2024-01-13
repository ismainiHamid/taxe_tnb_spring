import {Component, OnInit, ViewChild} from '@angular/core';
import {Client} from "../client/client.component";
import {Category} from "../category/category.component";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {LandService} from "./land.service";
import {NgForm} from "@angular/forms";
import {ClientService} from "../client/client.service";
import {CategoryService} from "../category/category.service";

export class Land {
  id?: number;
  nom?: string;
  surface?: number;
  client?: Client;
  category?: Category;
  createdAt?: Date;
}

@Component({
  selector: 'app-land',
  templateUrl: './land.component.html',
  styleUrls: ['./land.component.css']
})
export class LandComponent implements OnInit {
  public lands: Land[] = [];
  public land: Land;
  public clients: Client[] = [];
  public categories: Category[] = [];
  public displayedColumns: string[] = ['nom', 'surface', 'client', 'category', 'createdAt', 'actions'];
  public dataSource = new MatTableDataSource<Land>();
  @ViewChild(MatPaginator)
  public paginator?: MatPaginator;

  constructor(private landService: LandService, private clientService: ClientService, private categoryService: CategoryService) {
    this.land = new Land();
  }

  public ngOnInit(): void {
    this.findAll();
    this.findAllClients();
    this.findAllCategories();
  }

  public save(ngForm: NgForm) {
    this.landService.save(this.land).subscribe(result => {
      this.findAll();
      ngForm.resetForm();
    });

    console.log(this.land);
  }

  public delete(land: Land) {
    this.landService.delete(land).subscribe(result => {
      this.findAll();
    });
  }

  public findAll() {
    this.landService.findAll().subscribe(data => {
      this.lands = data;
      this.dataSource = new MatTableDataSource<Category>(this.lands);
      // @ts-ignore
      this.dataSource.paginator = this.paginator;
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

  public applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
