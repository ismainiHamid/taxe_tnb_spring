import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Tnb} from "./tnb.component";

@Injectable({
  providedIn: 'root'
})
export class TnbService {
  public uri: string = '/api/tnb/tnbApis/calculate';

  constructor(private httpClient:HttpClient) {}

  public calculate(tnb:Tnb){
    return this.httpClient.post<number>(this.uri, tnb);
  }
}
