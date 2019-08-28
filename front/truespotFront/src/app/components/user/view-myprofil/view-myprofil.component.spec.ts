import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ViewMyprofilComponent} from './view-myprofil.component';

describe('ViewProfilComponent', () => {
  let component: ViewMyprofilComponent;
  let fixture: ComponentFixture<ViewMyprofilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewMyprofilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMyprofilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
