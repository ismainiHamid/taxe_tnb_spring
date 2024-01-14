import {Component, OnInit, ViewChild} from '@angular/core';
import {Category} from "../category/category.component";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {RateService} from "../Rate/Rate.service";
import {CategoryService} from "../category/category.service";
import {NgForm} from "@angular/forms";

export class Rate {
  id?: number;
  ratePercent?: number;
  year?: number;
  createdAt?: Date;
}

@Component({
  selector: 'app-rate',
  templateUrl: './rate.component.html',
  styleUrls: ['./rate.component.css']
})
export class RateComponent implements OnInit{
  public rate: Rate;
  public rates: Rate[] = [];
  public categories: Category[] = [];
  public displayedColumns: string[] = ['ratePercent', 'year', 'createdAt', 'actions'];
  public dataSource = new MatTableDataSource<Rate>();
  @ViewChild(MatPaginator)
  public paginator?: MatPaginator;

  constructor(private rateService: RateService, private categoryService: CategoryService) {
    this.rate = new Rate();
  }

  public ngOnInit() {
    this.findAll();
    this.finAllCategories();
  }

  public save(ngFrom: NgForm) {
    this.rateService.save(this.rate).subscribe(result => {
      this.findAll();
      ngFrom.resetForm();
    })
  }

  public delete(Rate: Rate) {
    this.rateService.delete(Rate).subscribe(result => {
      this.findAll();
    });
  }

  public findAll() {
    this.rateService.findAll().subscribe(data => {
      this.rates = data;
      this.dataSource = new MatTableDataSource<Rate>(this.rates);
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
