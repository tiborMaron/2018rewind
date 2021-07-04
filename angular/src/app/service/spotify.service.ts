import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs/index";
import {SpotifyResult} from "../model/SpotifyResult";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class SpotifyService {

  private serverUri = environment.spotifyURI;

  getResults(): Observable<SpotifyResult[]>{
    return this.http.get<SpotifyResult[]>(this.serverUri + '/get-toplist')
  }

  getResultsByPage(page: number): Observable<SpotifyResult[]>{
    return null
  }

  constructor(
    private http: HttpClient
  ) { }
}
