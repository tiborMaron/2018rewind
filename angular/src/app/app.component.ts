import { Component } from '@angular/core';
import {NetflixResult} from "./model/NetflixResult";
import {YoutubeResult} from "./model/YoutubeResult";
import {GoogleResult} from "./model/GoogleResult";
import {SpotifyResult} from "./model/SpotifyResult";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  google: GoogleResult = {rank: 1, title: "Bitcoin"}
  netflix: NetflixResult = {rank: 1, title: "Daredevil"}
  spotify: SpotifyResult = {rank: 1, title: "Belehalok"}
  youtube: YoutubeResult = {rank: 1, title: "Despacito"}
}
