import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Tax} from "./tnb.component";
import {Land} from "../land/land.component";

@Injectable({
  providedIn: 'root'
})
export class TnbService {
  public uri: string = '/api/tnb-service/tnb';

  constructor(private httpClient: HttpClient) {
  }

  public calculate(tax: Tax) {
    return this.httpClient.get<number>(`${this.uri}/rate/${tax.year}/client/${tax.clientId}/land/${tax.landId}`);
  }

  public findAllLandsByClient(id: number) {
    return this.httpClient.get<Land[]>(`${this.uri}/findAllLandsByClient/${id}`);
  }

  public findAllTaxesByClient(id: number) {
    return this.httpClient.get<Tax[]>(`${this.uri}/findAllTaxesByClient/${id}`);
  }
}
