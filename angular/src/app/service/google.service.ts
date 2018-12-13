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

  getResults(): Observable<GoogleResult[]>{
    return this.http.get<GoogleResult[]>(this.serverUri + "/get-toplist");
  }

  getResultsByPage(page: number): Observable<GoogleResult[]> {
    return null;
  }

  constructor(
    private http: HttpClient
  ) { }
}
