import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewListRoadComponent } from './view-list-road.component';

describe('ViewListRoadComponent', () => {
  let component: ViewListRoadComponent;
  let fixture: ComponentFixture<ViewListRoadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewListRoadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewListRoadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
