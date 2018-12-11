import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import {GoogleResult} from "../model/GoogleResult";

@Injectable({
  providedIn: 'root'
})
export class GoogleService {

  private serverUri = '';

  private mock : GoogleResult[] = [{title: "title1", rank: 1}, {title: "title2", rank: 2}, {title: "title3", rank: 3}];

  getResults(): Observable<GoogleResult[]>{
    return of(this.mock)
  }

  getResultsByPage(page: number): Observable<GoogleResult[]> {
    return of(this.mock);
  }

  constructor() { }
}
