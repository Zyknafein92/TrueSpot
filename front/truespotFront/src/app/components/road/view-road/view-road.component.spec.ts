import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRoadComponent } from './view-road.component';

describe('ViewRoadComponent', () => {
  let component: ViewRoadComponent;
  let fixture: ComponentFixture<ViewRoadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewRoadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRoadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
