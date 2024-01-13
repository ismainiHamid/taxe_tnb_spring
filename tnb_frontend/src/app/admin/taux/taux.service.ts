import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Taux} from "./taux.component";

@Injectable({
  providedIn: 'root'
})
export class TauxService {
  public uri: string = '/api/tnb/taxes';

  constructor(private httpClient: HttpClient) {
  }

  public save(taux: Taux) {
    return this.httpClient.post<Taux>(this.uri, taux);
  }

  public update(taux: Taux) {
    return this.httpClient.put<Taux>(this.uri, taux);
  }

  public delete(taux: Taux) {
    return this.httpClient.delete<Taux>(`${this.uri}/${taux.id}`);
  }

  public findAll() {
    return this.httpClient.get<Taux[]>(this.uri);
  }
}
