import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUserprofilComponent } from './view-userprofil.component';

describe('ViewUserprofilComponent', () => {
  let component: ViewUserprofilComponent;
  let fixture: ComponentFixture<ViewUserprofilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewUserprofilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewUserprofilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
