import { Component } from '@angular/core';
import { CurrentComponentService } from '../Services/current-component.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  private isStateful: boolean = false;

  constructor(public currentComponentService: CurrentComponentService) {}


  toggleState() {
    this.isStateful = !this.isStateful;

    // You can perform additional actions based on the state change if needed
    if (this.isStateful) {
      // Do something when state becomes true
    } else {
      // Do something when state becomes false
    }
  }
}
