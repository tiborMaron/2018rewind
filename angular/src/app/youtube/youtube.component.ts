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
  categories: {id: number, name: string}[];
  selectedCategory: {id: number, name: string};

  constructor(
    private service: YoutubeService,
    private renderer: Renderer2
  ) {}

  ngOnInit() {
    this.service.getCountries().subscribe(
      countries => {
        this.countries = countries;
        this.selectedCountry = countries[0];
        this.service.getCategories(countries[0]).subscribe(
          categories => {
            this.categories = categories;
            this.selectedCategory = categories[0];
            this.updateCategory(this.selectedCategory);
          }
        )
      }
    );

    this.renderer.setStyle(document.body, 'background-color', '#ffffff')
  }

  updateCategory(category: {id: number, name: string}) {
    console.log(this.categories);
    console.log(this.countries);
    this.selectedCategory = category;
    this.service.getResults(this.selectedCountry, category).subscribe(results =>
       this.results = results
    );
  }

  updateCountry(country: {name: string, alpha2Code: string}) {
    this.selectedCountry = country;
    console.log(country.name);
    this.service.getCategories(country).subscribe(
      categories => {
        console.log(categories)
        this.categories = categories;
        this.selectedCategory = categories[0];
        this.updateCategory(this.selectedCategory);
      }
    )
  }

}
