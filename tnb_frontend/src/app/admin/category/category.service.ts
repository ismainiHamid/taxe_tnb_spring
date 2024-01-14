import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Category} from "./category.component";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  public uri:string = '/api/land-service/categories';
  constructor(private httpClient: HttpClient) { }

  public save(category:Category){
    return this.httpClient.post<Category>(this.uri, category);
  }

  public update(category:Category){
    return this.httpClient.put<Category>(this.uri, category);
  }

  public delete(category:Category){
    return this.httpClient.delete<Category>(`${this.uri}/${category.id}`);
  }

  public findAll(){
    return this.httpClient.get<Category[]>(this.uri);
  }
}
