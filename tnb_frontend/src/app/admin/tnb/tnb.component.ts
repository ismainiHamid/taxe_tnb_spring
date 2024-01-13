import {Component, OnInit} from '@angular/core';
import {Client} from "../client/client.component";
import {Land} from "../land/land.component";
import {TnbService} from "./tnb.service";
import {ClientService} from "../client/client.service";
import {LandService} from "../land/land.service";

export class Tnb {
  client?: Client;
  year?: number;
  land?: Land;
}

@Component({
  selector: 'app-tnb',
  templateUrl: './tnb.component.html',
  styleUrls: ['./tnb.component.css']
})
export class TnbComponent implements OnInit {
  public tnb: Tnb;
  public taxe?: number;
  public clients: Client[] = [];
  public lands: Land[] = [];

  constructor(private tnbService: TnbService, private clientService: ClientService, private landService: LandService) {
    this.tnb = new Tnb();
  }

  public ngOnInit() {
    this.findAllClient();
    this.findAllLands();
  }

  public calculate() {
    this.tnbService.calculate(this.tnb).subscribe(data => {
      this.taxe = data;
    });
  }

  public findAllClient() {
    this.clientService.findAll().subscribe(data => {
      this.clients = data;
    });
  }

  public findAllLands() {
    this.landService.findAll().subscribe(data => {
      this.lands = data;
    });
  }
}
