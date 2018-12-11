import {Component, Input, OnInit} from '@angular/core';
import {NetflixResult} from "../../model/NetflixResult";

@Component({
  selector: 'app-netflix-result',
  templateUrl: './netflix-result.component.html',
  styleUrls: ['./netflix-result.component.css']
})
export class NetflixResultComponent implements OnInit {

  @Input() result: NetflixResult;

  constructor() { }

  ngOnInit() {
  }

}
