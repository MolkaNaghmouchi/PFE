import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouteleveComponent } from './ajouteleve.component';

describe('AjouteleveComponent', () => {
  let component: AjouteleveComponent;
  let fixture: ComponentFixture<AjouteleveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjouteleveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouteleveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
