import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewListDepartmentComponent } from './view-list-department.component';

describe('ViewListDepartmentComponent', () => {
  let component: ViewListDepartmentComponent;
  let fixture: ComponentFixture<ViewListDepartmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewListDepartmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewListDepartmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
