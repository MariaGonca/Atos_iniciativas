import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuGestorComponent } from './menu-gestor.component';

describe('MenuGestorComponent', () => {
  let component: MenuGestorComponent;
  let fixture: ComponentFixture<MenuGestorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuGestorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuGestorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
