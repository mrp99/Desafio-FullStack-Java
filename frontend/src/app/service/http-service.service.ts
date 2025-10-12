import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private readonly urlApi = '/api'

  constructor(private http: HttpClient) { }

  get(url: string): Observable<any> {
    return this.http.get(`${this.urlApi}/${url}`);
  }

  post(url: string, body: any): Observable<any> {
    return this.http.post(`${this.urlApi}/${url}`, body);
  }

  put(url: string, body: any): Observable<any> {
    return this.http.put(`${this.urlApi}/${url}`, body);
  }

  delete(url: string): Observable<any> {
    return this.http.delete(`${this.urlApi}/${url}`);
  }
}
