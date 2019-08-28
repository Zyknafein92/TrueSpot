import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CreateRoadComponent} from './create-road.component';

describe('CreateRoadComponent', () => {
  let component: CreateRoadComponent;
  let fixture: ComponentFixture<CreateRoadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateRoadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateRoadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
