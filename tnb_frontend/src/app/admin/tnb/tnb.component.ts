import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Client} from "../client/client.component";
import {Land} from "../land/land.component";
import {TnbService} from "./tnb.service";
import {ClientService} from "../client/client.service";
import {LandService} from "../land/land.service";
import {NgForm} from "@angular/forms";
import {RateService} from "../rate/rate.service";
// @ts-ignore
import {Rate} from "../rate/rate.component";

export class Tax {
  year?: number;
  taxRising?: number;
  createdAt?: Date;
  clientId?: string;
  landId?: string;
}

@Component({
  selector: 'app-tnb',
  templateUrl: './tnb.component.html',
  styleUrls: ['./tnb.component.css']
})
export class TnbComponent implements OnInit {
  public tax: Tax;
  public taxResult?: number;
  public clients: Client[] = [];
  public lands: Land[] = [];
  public landsByClient: Land[] = [];
  public taxesByClient: Tax[] = [];
  public rates: Rate[] = [];

  constructor(private tnbService: TnbService, private clientService: ClientService, private landService: LandService, private rateService: RateService) {
    this.tax = new Tax();
  }

  public ngOnChangeLand(value: any): void {
    this.findAllLandsByClient(parseInt(value.target.value));
  }

  public ngOnChangeTaxes(value: any) {
    this.findAllTaxesByClient(parseInt(value.target.value));
  }

  public ngOnInit() {
    this.findAllClient();
    this.findAllLands();
    this.findAllRates();
  }

  public calculate(ngForm: NgForm) {
    this.tnbService.calculate(this.tax).subscribe(result => {
      this.taxResult = result;
      ngForm.resetForm();
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

  public findAllLandsByClient(client: number) {
    return this.tnbService.findAllLandsByClient(client).subscribe(data => {
      this.landsByClient = data;
    });
  }

  public findAllTaxesByClient(id: number) {
    return this.tnbService.findAllTaxesByClient(id).subscribe(data => {
      this.taxesByClient = data;
    });
  }

  public findAllRates() {
    this.rateService.findAll().subscribe(data => {
      this.rates = data;
    });
  }
}
