import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from '@angular/material/table';
import {CategoryService} from "./category.service";
import {NgForm} from "@angular/forms";

export class Category {
  id?: number;
  label?: string;
  rising?: string;
  createdAt?: Date;
}

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css'],
})
export class CategoryComponent implements OnInit {
  public categories: Category[] = [];
  public displayedColumns: string[] = ['label', 'rising', 'createdAt', 'actions'];
  public dataSource = new MatTableDataSource<Category>();
  @ViewChild(MatPaginator)
  public paginator?: MatPaginator;

  constructor(private categoryService: CategoryService) {
  }

  public ngOnInit() {
    this.findAll();
  }

  public delete(category: Category) {
    this.categoryService.delete(category).subscribe(result => {
      this.findAll();
    });
  }

  public findAll() {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
      this.dataSource = new MatTableDataSource<Category>(this.categories);
      // @ts-ignore
      this.dataSource.paginator = this.paginator;
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
