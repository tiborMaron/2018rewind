import {Component, Input, OnInit} from '@angular/core';
import {YoutubeResult} from "../../model/YoutubeResult";

@Component({
  selector: 'app-youtube-result',
  templateUrl: './youtube-result.component.html',
  styleUrls: ['./youtube-result.component.css']
})
export class YoutubeResultComponent implements OnInit {

  @Input() result: YoutubeResult;

  constructor() { }

  ngOnInit() {
  }

}
