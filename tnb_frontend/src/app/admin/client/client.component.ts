import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {ClientService} from "./client.service";
import {NgForm} from "@angular/forms";
import {Category} from "../category/category.component";

export class Client {
  id?: number;
  fullName?: string;
  cardNumber?: string;
  createdAt?: Date;
}

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
  public clients: Client[] = [];
  public displayedColumns: string[] = ['fullName', 'cardNumber', 'createdAt', 'actions'];
  public dataSource = new MatTableDataSource<Client>();
  @ViewChild(MatPaginator)
  public paginator?: MatPaginator;

  constructor(private clientService: ClientService) {
  }

  public ngOnInit(): void {
    this.findAll();
  }

  public delete(client: Client) {
    this.clientService.delete(client).subscribe(result => {
      this.findAll();
    });
  }

  public findAll() {
    this.clientService.findAll().subscribe(data => {
      this.clients = data;
      this.dataSource = new MatTableDataSource<Category>(this.clients);
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
