import {Component, Input, OnInit} from '@angular/core';
import {GoogleResult} from "../../model/GoogleResult";

@Component({
  selector: 'app-google-result',
  templateUrl: './google-result.component.html',
  styleUrls: ['./google-result.component.css']
})
export class GoogleResultComponent implements OnInit {

  @Input() result: GoogleResult;

  constructor() { }

  ngOnInit() {
  }

}
