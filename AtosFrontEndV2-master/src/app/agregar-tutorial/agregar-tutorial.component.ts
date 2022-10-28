import { Component, OnInit } from '@angular/core';
import { Tutorial } from 'src/app/modelos/tutorial.model';
import { TutorialService } from 'src/app/_services/tutorial.service';

@Component({
  selector: 'app-agregar-tutorial',
  templateUrl: './agregar-tutorial.component.html',
  styleUrls: ['./agregar-tutorial.component.css']
})  
export class AgregarTutorialComponent implements OnInit {

  tutorial: Tutorial = {
    titulo: '',
    descripcion: '',
    imagen: '',
    publicado: false
  };
  submitted = false;

  constructor(private tutorialService: TutorialService) { }

  ngOnInit(): void {
  }
  //Metodo de guardar Imagenes
  guardarTutorial(): void {
    const data = {
      titulo: this.tutorial.titulo,
      descripcion: this.tutorial.descripcion,
      imagen: this.tutorial.imagen
    };

    this.tutorialService.crearTutorial(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        
        error: (e) => console.error(e)
      });
  }
  //Metodo de Nueva Imagen
  nuevoTutorial(): void {
    this.submitted = false;
    this.tutorial = {
      titulo: '',
      descripcion: '',
      imagen: '',
      publicado: false
    };
  }
}