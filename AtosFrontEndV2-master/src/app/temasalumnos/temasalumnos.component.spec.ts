import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TemasalumnosComponent } from './temasalumnos.component';

describe('TemasalumnosComponent', () => {
  let component: TemasalumnosComponent;
  let fixture: ComponentFixture<TemasalumnosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TemasalumnosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TemasalumnosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
