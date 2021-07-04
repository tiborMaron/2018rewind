import {Component, Input, OnInit} from '@angular/core';
import {SpotifyResult} from "../../model/SpotifyResult";

@Component({
  selector: 'app-spotify-result',
  templateUrl: './spotify-result.component.html',
  styleUrls: ['./spotify-result.component.css']
})
export class SpotifyResultComponent implements OnInit {

  @Input() result: SpotifyResult;
  @Input() rank: number;

  constructor() { }

  ngOnInit() {
  }

}
