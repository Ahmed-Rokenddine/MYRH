import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgentCompComponent } from './agent-comp.component';

describe('AgentCompComponent', () => {
  let component: AgentCompComponent;
  let fixture: ComponentFixture<AgentCompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgentCompComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AgentCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
