import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatepayementComponent } from './updatepayement.component';

describe('UpdatepayementComponent', () => {
  let component: UpdatepayementComponent;
  let fixture: ComponentFixture<UpdatepayementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatepayementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatepayementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
