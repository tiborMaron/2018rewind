import { Component, OnInit } from '@angular/core';
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
    private service: NetflixService
  ) { }

  ngOnInit() {
    this.service.getResults().subscribe(
      results => this.results = results
    )
  }

}
