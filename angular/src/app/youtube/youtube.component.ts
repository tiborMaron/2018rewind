import {Component, OnInit, Renderer2} from '@angular/core';
import {YoutubeResult} from "../model/YoutubeResult";
import {YoutubeService} from "../service/youtube.service";

@Component({
  selector: 'app-youtube',
  templateUrl: './youtube.component.html',
  styleUrls: ['./youtube.component.css']
})
export class YoutubeComponent implements OnInit {

  results: YoutubeResult[];

  constructor(
    private service: YoutubeService,
    private renderer: Renderer2
  ) {}

  ngOnInit() {
    this.service.getResults().subscribe(
      results => this.results = results
    );

    this.renderer.setStyle(document.body, 'background-color', '#ffffff')
  }

}
