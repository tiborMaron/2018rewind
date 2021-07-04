import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {YoutubeComponent} from "./youtube/youtube.component";
import {SpotifyComponent} from "./spotify/spotify.component";
import {NetflixComponent} from "./netflix/netflix.component";
import {GoogleComponent} from "./google/google.component";

const routes: Routes = [
  {path:'', redirectTo: 'youtube', pathMatch: 'full'},
  {path:'youtube', component: YoutubeComponent},
  {path:'netflix', component: NetflixComponent},
  {path:'spotify', component: SpotifyComponent},
  {path:'google', component: GoogleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
