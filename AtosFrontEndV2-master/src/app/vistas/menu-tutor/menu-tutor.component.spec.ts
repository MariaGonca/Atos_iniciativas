import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuTutorComponent } from './menu-tutor.component';

describe('MenuTutorComponent', () => {
  let component: MenuTutorComponent;
  let fixture: ComponentFixture<MenuTutorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuTutorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuTutorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
