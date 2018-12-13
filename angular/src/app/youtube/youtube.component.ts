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
  countries: {name: string, alpha2Code: string}[];
  selectedCountry: {name: string, alpha2Code: string};

  constructor(
    private service: YoutubeService,
    private renderer: Renderer2
  ) {}

  ngOnInit() {
    this.service.getCountries().subscribe(
      countries => {
        this.countries = countries;
        this.selectedCountry = countries[0];
        this.updateData(this.selectedCountry, 1);
      }
    );

    this.renderer.setStyle(document.body, 'background-color', '#ffffff')
  }

  updateData(country: {name: string, alpha2Code: string}, category: number) {
    this.service.getResults(country, category).subscribe(results =>
       this.results = results
    );
  }

}
