import {Component, OnInit} from '@angular/core';
import {CurrentComponentService} from "../Services/current-component.service";

@Component({
  selector: 'app-home-comp',
  templateUrl: './home-comp.component.html',
  styleUrls: ['./home-comp.component.css']
})
export class HomeCompComponent implements OnInit{
  constructor(
    private currentComponentService: CurrentComponentService
  ) {
  }

  ngOnInit() {
    this.currentComponentService.setCurrentComponent('home');
  }
}
