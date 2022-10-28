import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TutorialDetallesComponent } from './tutorial-detalles.component';

describe('TutorialDetallesComponent', () => {
  let component: TutorialDetallesComponent;
  let fixture: ComponentFixture<TutorialDetallesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TutorialDetallesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TutorialDetallesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
