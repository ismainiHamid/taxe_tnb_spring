import {Component} from '@angular/core';
import {Category, CategoryComponent} from "../category.component";
import {NgForm} from "@angular/forms";
import {CategoryService} from "../category.service";

@Component({
  selector: 'app-save-category',
  templateUrl: './save-category.component.html',
  styleUrls: ['./save-category.component.css']
})
export class SaveCategoryComponent {
  public category: Category;

  constructor(private categoryService: CategoryService, private categoryComponent: CategoryComponent) {
    this.category = new Category();
  }

  public save(ngForm: NgForm) {
    this.categoryService.save(this.category).subscribe(result => {
      this.categoryComponent.findAll();
      ngForm.resetForm();
    });
  }
}
