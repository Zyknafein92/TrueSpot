import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ViewListUsersComponent} from './view-list-users.component';

describe('ViewListUsersComponent', () => {
  let component: ViewListUsersComponent;
  let fixture: ComponentFixture<ViewListUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewListUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewListUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
