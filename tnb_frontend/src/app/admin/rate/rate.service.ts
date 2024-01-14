import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
// @ts-ignore
import {Rate} from "./rate.component";

@Injectable({
  providedIn: 'root'
})
export class RateService {
  public uri: string = '/api/tax-service/rates';

  constructor(private httpClient: HttpClient) {
  }

  public save(rate: Rate) {
    return this.httpClient.post<Rate>(this.uri, rate);
  }

  public update(rate: Rate) {
    return this.httpClient.put<Rate>(this.uri, rate);
  }

  public delete(rate: Rate) {
    return this.httpClient.delete<Rate>(`${this.uri}/${rate.id}`);
  }

  public findAll() {
    return this.httpClient.get<Rate[]>(this.uri);
  }
}
