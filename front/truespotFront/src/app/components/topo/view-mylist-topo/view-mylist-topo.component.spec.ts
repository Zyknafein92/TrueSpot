import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ViewMylistTopoComponent} from './view-mylist-topo.component';

describe('ViewMylistTopoComponent', () => {
  let component: ViewMylistTopoComponent;
  let fixture: ComponentFixture<ViewMylistTopoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewMylistTopoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMylistTopoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
