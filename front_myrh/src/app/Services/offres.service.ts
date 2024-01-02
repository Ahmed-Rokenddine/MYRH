import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OffresService {

  constructor(private http: HttpClient) { }

  public addoffre(offre: any) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post("http://localhost:8080/app/Offres", offre, { headers });
  }

  public getoffres( page : number = 0,  size: number = 10){
    return this.http.get(`http://localhost:8080/app/allOffres?page=${page}&size=${size}`, { observe: 'response' });
  }

  public getoffreById(id: number): Observable<any> {
    return this.http.get(`http://localhost:8080/app/Offres?id=${id}`);
  }
}
