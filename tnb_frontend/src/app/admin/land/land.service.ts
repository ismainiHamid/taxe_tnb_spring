import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Land} from "./land.component";

@Injectable({
  providedIn: 'root'
})
export class LandService {
  public uri: string = '/api/land-service/lands'

  constructor(private httpClient: HttpClient) {
  }

  public save(land: Land) {
    return this.httpClient.post<Land>(this.uri, land);
  }

  public update(land: Land) {
    return this.httpClient.put<Land>(this.uri, land);
  }

  public delete(land: Land) {
    return this.httpClient.delete<Land>(`${this.uri}/${land.id}`);
  }

  public findAll() {
    return this.httpClient.get<Land[]>(this.uri);
  }
}
