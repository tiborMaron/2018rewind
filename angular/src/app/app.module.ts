import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './header/navbar/navbar.component';
import { SliderComponent } from './header/navbar/slider/slider.component';
import { YoutubeComponent } from './youtube/youtube.component';
import { SpotifyComponent } from './spotify/spotify.component';
import { GoogleComponent } from './google/google.component';
import { NetflixComponent } from './netflix/netflix.component';
import { YoutubeResultComponent } from './youtube/youtube-result/youtube-result.component';
import { SpotifyResultComponent } from './spotify/spotify-result/spotify-result.component';
import { GoogleResultsComponent } from './google/google-results/google-results.component';
import { NetflixResultComponent } from './netflix/netflix-result/netflix-result.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NavbarComponent,
    SliderComponent,
    YoutubeComponent,
    SpotifyComponent,
    GoogleComponent,
    NetflixComponent,
    YoutubeResultComponent,
    SpotifyResultComponent,
    GoogleResultsComponent,
    NetflixResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
