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
  address?: string;
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
  public displayedColumns: string[] = ['address', 'surface', 'client', 'category', 'createdAt', 'actions'];
  public dataSource = new MatTableDataSource<Land>();
  @ViewChild(MatPaginator)
  public paginator?: MatPaginator;

  constructor(private landService: LandService) {
  }

  public ngOnInit(): void {
    this.findAll();
  }

  public delete(land: Land) {
    this.landService.delete(land).subscribe(result => {
      this.findAll();
    });
  }

  public findAll() {
    this.landService.findAll().subscribe(data => {
      this.lands = data;
      this.dataSource = new MatTableDataSource<Land>(this.lands);
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
