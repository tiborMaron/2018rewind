import { Injectable } from '@angular/core';
import {GoogleResult} from "../model/GoogleResult";
import {Observable, of} from "rxjs/index";
import {YoutubeResult} from "../model/YoutubeResult";

@Injectable({
  providedIn: 'root'
})
export class YoutubeService {

  private serverUri = '';

  private mock : YoutubeResult[] = [{title: "title1", rank: 1}, {title: "title2", rank: 2}, {title: "title3", rank: 3}];

  getResults(): Observable<YoutubeResult[]>{
    return of(this.mock);
  }

  getResults(page: number): YoutubeResult[] {
    return of(this.mock);
  }

  constructor() { }
}
