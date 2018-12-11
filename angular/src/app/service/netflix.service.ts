import { Injectable } from '@angular/core';
import {NetflixResult} from "../model/NetflixResult";
import {Observable, of} from "rxjs/index";

@Injectable({
  providedIn: 'root'
})
export class NetflixService{

  private serverUri = '';

  private mock : NetflixResult[] = [{title: "title1", rank: 1}, {title: "title2", rank: 2}, {title: "title3", rank: 3}];

  getResults(): Observable<NetflixResult[]>{
    return of(this.mock)
  }

  getResults(page: number): NetflixResult[] {
    return of(this.mock);
  }

  constructor() { }
}
