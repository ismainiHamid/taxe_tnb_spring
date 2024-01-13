import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Client} from "./client.component";

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  public uri: string = "/tnb/clients";

  constructor(private httpClient: HttpClient) {
  }

  public save(client: Client) {
    return this.httpClient.post<Client>(this.uri, client);
  }

  public update(client: Client) {
    return this.httpClient.put<Client>(this.uri, client);
  }

  public delete(client: Client) {
    return this.httpClient.delete<Client>(`${this.uri}/${client.id}`);
  }

  public findAll() {
    return this.httpClient.get<Client[]>(this.uri);
  }
}
