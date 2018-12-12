import {Component, OnInit, Renderer2} from '@angular/core';
import {GoogleResult} from "../model/GoogleResult";
import {GoogleService} from "../service/google.service";

@Component({
  selector: 'app-google',
  templateUrl: './google.component.html',
  styleUrls: ['./google.component.css']
})
export class GoogleComponent implements OnInit {

  results: GoogleResult[];

  constructor(
    private service: GoogleService,
    private renderer: Renderer2
  ) { }

  ngOnInit() {
    this.service.getResults().subscribe(
      results => this.results = results
    );

    this.renderer.setStyle(document.body, 'background-color', '#ffffff')
  }

}
