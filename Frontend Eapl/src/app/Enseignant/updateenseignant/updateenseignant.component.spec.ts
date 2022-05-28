import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateenseignantComponent } from './updateenseignant.component';

describe('UpdateenseignantComponent', () => {
  let component: UpdateenseignantComponent;
  let fixture: ComponentFixture<UpdateenseignantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateenseignantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateenseignantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
