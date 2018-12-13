import { Injectable } from '@angular/core';
import {Observable, of} from "rxjs/index";
import {YoutubeResult} from "../model/YoutubeResult";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class YoutubeService {

  private country: {name: string, alpha2Code: string};

  private serverUri = environment.youtubeURI;

  getResults(country: {name: string, alpha2Code: string}, category: {id: number, name: string}): Observable<YoutubeResult[]>{
    if (category == undefined)
      return of([]);
    return this.http.get<YoutubeResult[]>(this.serverUri + '/topvideos/' + country.alpha2Code +'/' + category.id);
  }

  getCountries(): Observable<{name: string, alpha2Code: string}[]> {
    return this.http.get<{name: string, alpha2Code: string}[]>("https://restcountries.eu/rest/v2/all?fields=name%3Balpha2Code&fbclid=IwAR1vn1li-Z-nYF2loK0wcFv0o2qHvT3KN2y3IMIOniDwHdgbWIBNONN33cQ");
  }

  getCategories(country: {name: string, alpha2Code: string}): Observable<{id: number, name: string}[]> {
    return this.http.get<{id: number, name: string}[]>(this.serverUri + '/categories/' + country.alpha2Code)
  }


  constructor(
    private http: HttpClient
  ) { }
}
