import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
// @ts-ignore
import {RateService} from "./rate.service";

export class Rate {
  id?: number;
  ratePercent?: number;
  year?: number;
  categoryId?: number;
  createdAt?: Date;
}

@Component({
  selector: 'app-rate',
  templateUrl: './rate.component.html',
  styleUrls: ['./rate.component.css']
})
export class RateComponent implements OnInit {
  public rates: Rate[] = [];
  public displayedColumns: string[] = ['ratePercent', 'year', 'createdAt', 'actions'];
  public dataSource = new MatTableDataSource<Rate>();
  @ViewChild(MatPaginator)
  public paginator?: MatPaginator;

  constructor(private rateService: RateService) {
  }

  public ngOnInit() {
    this.findAll();
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

  public applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
