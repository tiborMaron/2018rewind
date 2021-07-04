import { Component, OnInit } from '@angular/core';
import {NavigationEnd, Router} from "@angular/router";

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.css']
})
export class SliderComponent implements OnInit {

  positionStyle: string;

  order = [
    {name: "youtube", position: 1},
    {name: "netflix", position: 2},
    {name: "spotify", position: 3},
    {name: "google", position: 4},
    ];

  constructor(
    private router: Router
  ) { }

  ngOnInit() {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        let selected = event.url.substring(1);
        for (let index in this.order){
          if (this.order[index].name === selected) {
            let positionPercent = (this.order[index].position - 1) * 25;
            this.positionStyle = positionPercent.toString() + "%";
            break;
          }
        }
      }
    })
  }

}
