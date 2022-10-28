import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaIniciativaComponent } from './lista-iniciativa.component';

describe('ListaIniciativaComponent', () => {
  let component: ListaIniciativaComponent;
  let fixture: ComponentFixture<ListaIniciativaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListaIniciativaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaIniciativaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
