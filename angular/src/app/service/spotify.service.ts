import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs/index";
import {SpotifyResult} from "../model/SpotifyResult";

@Injectable({
  providedIn: 'root'
})
export class SpotifyService {

  private serverUri = '';

  private mock : SpotifyResult[] = [{title: "title1", rank: 1}, {title: "title2", rank: 2}, {title: "title3", rank: 3}];

  getResults(): Observable<SpotifyResult[]>{
    return of(this.mock)
  }

  getResultsByPage(page: number): Observable<SpotifyResult[]>{
    return of(this.mock);
  }

  constructor() { }
}
