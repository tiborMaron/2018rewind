import { Component, OnInit } from '@angular/core';
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
    private service: GoogleService
  ) { }

  ngOnInit() {
    this.service.getResults().subscribe(
      results => this.results = results
    )
  }

}
