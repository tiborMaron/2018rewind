import { Injectable } from '@angular/core';
import {NetflixResult} from "../model/NetflixResult";
import {Observable, of} from "rxjs/index";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class NetflixService{

  private serverUri = environment.netflixURI;

  getResults(): Observable<NetflixResult[]>{
    return this.http.get<NetflixResult[]>(this.serverUri + "/netflix")
  }

  getResultsByPage(page: number): Observable<NetflixResult[]>{
    return null;
  }

  constructor(
    private http: HttpClient
  ) { }
}
