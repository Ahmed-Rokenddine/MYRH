import { Component } from '@angular/core';
import {CurrentComponentService} from "../Services/current-component.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(public currentComponentService: CurrentComponentService) {}
}
