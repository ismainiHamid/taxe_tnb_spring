import {Component, OnInit, ViewChild} from '@angular/core';
import {Category} from "../category/category.component";
import {TauxService} from "./taux.service";
import {CategoryService} from "../category/category.service";
import {NgForm} from "@angular/forms";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";

export class Taux {
  id?: number;
  montant?: number;
  category?: Category;
  createdAt?: Date;
}

@Component({
  selector: 'app-taux',
  templateUrl: './taux.component.html',
  styleUrls: ['./taux.component.css']
})
export class TauxComponent implements OnInit {
  public taux: Taux;
  public tauxes: Taux[] = [];
  public categories: Category[] = [];
  public displayedColumns: string[] = ['montant', 'category', 'createdAt', 'actions'];
  public dataSource = new MatTableDataSource<Taux>();
  @ViewChild(MatPaginator)
  public paginator?: MatPaginator;

  constructor(private tauxService: TauxService, private categoryService: CategoryService) {
    this.taux = new Taux();
  }

  public ngOnInit() {
    this.findAll();
    this.finAllCategories();
  }

  public save(ngFrom: NgForm) {
    this.tauxService.save(this.taux).subscribe(result => {
      this.findAll();
      ngFrom.resetForm();
    })
  }

  public delete(taux: Taux) {
    this.tauxService.delete(taux).subscribe(result => {
      this.findAll();
    });
  }

  public findAll() {
    this.tauxService.findAll().subscribe(data => {
      this.tauxes = data;
      this.dataSource = new MatTableDataSource<Taux>(this.tauxes);
      // @ts-ignore
      this.dataSource.paginator = this.paginator;
    });
  }

  public finAllCategories() {
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
