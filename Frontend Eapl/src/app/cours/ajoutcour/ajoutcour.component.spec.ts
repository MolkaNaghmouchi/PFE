import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutcourComponent } from './ajoutcour.component';

describe('AjoutcourComponent', () => {
  let component: AjoutcourComponent;
  let fixture: ComponentFixture<AjoutcourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjoutcourComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AjoutcourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
