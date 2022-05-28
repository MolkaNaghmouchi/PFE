import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListenseignantComponent } from './listenseignant.component';

describe('ListenseignantComponent', () => {
  let component: ListenseignantComponent;
  let fixture: ComponentFixture<ListenseignantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListenseignantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListenseignantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
