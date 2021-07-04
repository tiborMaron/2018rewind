import {Component, ElementRef, OnInit, Renderer2} from '@angular/core';
import {NetflixResult} from "../model/NetflixResult";
import {NetflixService} from "../service/netflix.service";

@Component({
  selector: 'app-netflix',
  templateUrl: './netflix.component.html',
  styleUrls: ['./netflix.component.css']
})
export class NetflixComponent implements OnInit {

  results: NetflixResult[];

  constructor(
    private service: NetflixService,
    private renderer: Renderer2
  ) { }

  ngOnInit() {
    this.service.getResults().subscribe(
      results => this.results = results
    );

    this.renderer.setStyle(document.body, 'background-color', '#141414')
  }

}
