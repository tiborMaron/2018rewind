import {Component, Input, OnInit} from '@angular/core';
import {YoutubeResult} from "../../model/YoutubeResult";
import {DomSanitizer, SafeResourceUrl} from "@angular/platform-browser";

@Component({
  selector: 'app-youtube-result',
  templateUrl: './youtube-result.component.html',
  styleUrls: ['./youtube-result.component.css']
})
export class YoutubeResultComponent implements OnInit {

  @Input() result: YoutubeResult;
  @Input() rank: number;
  videoURL: SafeResourceUrl;

  constructor(
    private sanitizer: DomSanitizer
  ) { }

  ngOnInit() {
    this.videoURL =
      this.sanitizer.bypassSecurityTrustResourceUrl('https://www.youtube.com/embed/' + this.result.id);
  }

}
