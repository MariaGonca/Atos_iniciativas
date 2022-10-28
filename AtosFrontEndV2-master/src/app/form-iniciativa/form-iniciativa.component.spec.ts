import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormIniciativaComponent } from './form-iniciativa.component';

describe('FormIniciativaComponent', () => {
  let component: FormIniciativaComponent;
  let fixture: ComponentFixture<FormIniciativaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormIniciativaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormIniciativaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
