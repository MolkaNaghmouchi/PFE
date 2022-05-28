import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutseanceComponent } from './ajoutseance.component';

describe('AjoutseanceComponent', () => {
  let component: AjoutseanceComponent;
  let fixture: ComponentFixture<AjoutseanceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjoutseanceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AjoutseanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
