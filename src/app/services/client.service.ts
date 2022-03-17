import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Client } from '../model/client';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private baseUrl: string = 'http://localhost:8081/clients/';
  private httpHeaders = new HttpHeaders()
  .set('Content-Type', 'application/json')
  .set('Access-Control-Allow-Origin', 'localhost:4200'); 
  
  constructor(private httpClient: HttpClient) {}

  getClients(): Observable<any> 
  {
    return this.httpClient.get(`${this.baseUrl}` + 'findAll');
  }

  getClient(id: number): Observable<any> {
    console.log("getClient() id is: "+id)
    return this.httpClient.get(`${this.baseUrl}find/${id}`);
  }

  addClient(client: Client): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}` + 'insert', client, { headers: this.httpHeaders });
  }

  modClient(client: Client): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}` + 'update', client, { headers: this.httpHeaders });
  }

  delClient(id: number): Observable<Object> {
    console.log(id);
    return this.httpClient.delete(`${this.baseUrl}delete/${id}`);
  }
}
