import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ViewListTopoComponent} from './view-list-topo.component';

describe('ViewListTopoComponent', () => {
  let component: ViewListTopoComponent;
  let fixture: ComponentFixture<ViewListTopoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewListTopoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewListTopoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
