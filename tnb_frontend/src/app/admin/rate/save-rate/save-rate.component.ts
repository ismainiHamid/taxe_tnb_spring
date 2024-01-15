import {Component, OnInit} from '@angular/core';
// @ts-ignore
import {Rate, RateComponent} from "../rate.component";
import {NgForm} from "@angular/forms";
import {CategoryService} from "../../category/category.service";
import {Category} from "../../category/category.component";
// @ts-ignore
import {RateService} from "../rate.service";


@Component({
  selector: 'app-save-rate',
  templateUrl: './save-rate.component.html',
  styleUrls: ['./save-rate.component.css']
})
export class SaveRateComponent implements OnInit {
  public rate: Rate;
  public categories: Category[] = [];


  constructor(private rateService: RateService, private rateComponent: RateComponent, private categoryService: CategoryService) {
    this.rate = new Rate();
  }

  public ngOnInit(): void {
    this.finAllCategories();
  }

  public save(ngFrom: NgForm) {
    this.rateService.save(this.rate).subscribe(result => {
      this.rateComponent.findAll();
      ngFrom.resetForm();
    })
  }

  public finAllCategories() {
    this.categoryService.findAll().subscribe(data => {
      this.categories = data;
    });
  }
}
