import {Component, OnDestroy, OnInit, Renderer2} from '@angular/core';
import {SpotifyResult} from "../model/SpotifyResult";
import {SpotifyService} from "../service/spotify.service";

@Component({
  selector: 'app-spotify',
  templateUrl: './spotify.component.html',
  styleUrls: ['./spotify.component.css']
})
export class SpotifyComponent implements OnInit, OnDestroy {

  results: SpotifyResult[];

  constructor(
    private service: SpotifyService,
    private renderer: Renderer2
  ) { }

  ngOnInit() {
    this.service.getResults().subscribe(
      results => this.results = results
    );

    this.renderer.setStyle(document.body, 'background', 'linear-gradient(transparent, #006f27)');
    this.renderer.setStyle(document.body, 'background-attachment', 'fixed');
    this.renderer.setStyle(document.body, 'background-color', 'grey');


  }

  ngOnDestroy(){
    this.renderer.setStyle(document.body, 'background', 'unset');
  }

}
