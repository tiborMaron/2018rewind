import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs/index";
import {YoutubeResult} from "../model/YoutubeResult";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class YoutubeService {

  private serverUri = environment.youtubeURI;

  getResults(): Observable<YoutubeResult[]>{
    return this.http.get<YoutubeResult[]>(this.serverUri + '/topvideos/HU/1');
  }

  getResultsByPage(page: number): Observable<YoutubeResult[]>{
    return null;
  }

  constructor(
    private http: HttpClient
  ) { }
}
