import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutenseignantComponent } from './ajoutenseignant.component';

describe('AjoutenseignantComponent', () => {
  let component: AjoutenseignantComponent;
  let fixture: ComponentFixture<AjoutenseignantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjoutenseignantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AjoutenseignantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
