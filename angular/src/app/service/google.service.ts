import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {GoogleResult} from "../model/GoogleResult";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class GoogleService {

  private serverUri = environment.googleURI;

  private mock : GoogleResult[] = [{title: "title1", rank: 1}, {title: "title2", rank: 2}, {title: "title3", rank: 3}];

  getResults(): Observable<GoogleResult[]>{
    return this.http.get<GoogleResult[]>(this.serverUri + "/get-toplist");
  }

  getResultsByPage(page: number): Observable<GoogleResult[]> {
    return of(this.mock);
  }

  constructor(
    private http: HttpClient
  ) { }
}
