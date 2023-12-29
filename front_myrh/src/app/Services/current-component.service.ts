import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CurrentComponentService {
  public currentComponent: string = '';

  setCurrentComponent(component: string): void {
    this.currentComponent = component;
  }
}
