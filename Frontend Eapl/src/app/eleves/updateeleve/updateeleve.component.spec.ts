import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateeleveComponent } from './updateeleve.component';

describe('UpdateeleveComponent', () => {
  let component: UpdateeleveComponent;
  let fixture: ComponentFixture<UpdateeleveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateeleveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateeleveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
