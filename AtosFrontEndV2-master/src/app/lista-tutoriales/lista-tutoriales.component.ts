import { Component, OnInit } from '@angular/core';
import { Tutorial } from 'src/app/modelos/tutorial.model';
import { TutorialService } from 'src/app/_services/tutorial.service';

@Component({
  selector: 'app-lista-tutoriales',
  templateUrl: './lista-tutoriales.component.html',
  styleUrls: ['./lista-tutoriales.component.css']
})
export class ListaTutorialesComponent implements OnInit {

  tutoriales?: Tutorial[];
  tutorialActual: Tutorial = {};
  indiceActual = -1;
  titulo = '';

  constructor(private tutorialService: TutorialService) { }

  ngOnInit(): void {
  
    this.recuperarTutoriales();
  }
  //Metodo de Recuperar Tutoriales
  recuperarTutoriales(): void {
    this.tutorialService.getTodosTutoriales()
      .subscribe({
        next: (data) => {
          this.tutoriales = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  //Metodo de Refrescar Lista
  refrescarLista(): void {
    this.recuperarTutoriales();
    this.tutorialActual = {};
    this.indiceActual = -1;
  }
  //Metodo de Tutorial Activo
  setTutorialActivo(tutorial: Tutorial, indice: number): void {
    this.tutorialActual = tutorial;
    this.indiceActual = indice;
  }
  //Metodo de Eliminar todas las Imagenes
  eliminarTodosTutoriales(): void {
    this.tutorialService.eliminarTodosTutoriales()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refrescarLista();
        },
        error: (e) => console.error(e)
      });
  }
  //Metodo de Buscar por Titulo
  buscarTitulo(): void {
    this.tutorialActual = {};
    this.indiceActual = -1;

    this.tutorialService.findByTitulo(this.titulo) 
      .subscribe({
        next: (data) => {
          this.tutoriales = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

}

