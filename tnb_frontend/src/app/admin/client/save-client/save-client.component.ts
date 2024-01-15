import {Component} from '@angular/core';
import {Client, ClientComponent} from "../client.component";
import {ClientService} from "../client.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-save-client',
  templateUrl: './save-client.component.html',
  styleUrls: ['./save-client.component.css']
})
export class SaveClientComponent {
  public client: Client;

  constructor(private clientService: ClientService, private clientComponent: ClientComponent) {
    this.client = new Client();
  }

  public save(ngForm: NgForm) {
    this.clientService.save(this.client).subscribe(result => {
      this.clientComponent.findAll();
      ngForm.resetForm();
    });
  }

}
