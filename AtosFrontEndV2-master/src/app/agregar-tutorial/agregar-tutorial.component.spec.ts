import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarTutorialComponent } from './agregar-tutorial.component';

describe('AgregarTutorialComponent', () => {
  let component: AgregarTutorialComponent;
  let fixture: ComponentFixture<AgregarTutorialComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AgregarTutorialComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AgregarTutorialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
