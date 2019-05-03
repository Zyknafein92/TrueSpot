import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewListAreaComponent } from './view-list-area.component';

describe('ViewListAreaComponent', () => {
  let component: ViewListAreaComponent;
  let fixture: ComponentFixture<ViewListAreaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewListAreaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewListAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
