import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTopoComponent } from './view-topo.component';

describe('ViewTopoComponent', () => {
  let component: ViewTopoComponent;
  let fixture: ComponentFixture<ViewTopoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewTopoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewTopoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
