import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tutorial } from 'src/app/modelos/tutorial.model';
import { TutorialService } from 'src/app/_services/tutorial.service';

@Component({
  selector: 'app-tutorial-detalles',
  templateUrl: './tutorial-detalles.component.html',
  styleUrls: ['./tutorial-detalles.component.css']
})
export class TutorialDetallesComponent implements OnInit {


  @Input() viewMode = false;

  @Input() tutorialActual: Tutorial = {
    titulo: '',
    descripcion: '',
    publicado: false,
    imagen: ''
  };

  message = ''

  constructor(
    private tutorialService: TutorialService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getTutorial(this.route.snapshot.params["id"]);
    }
  }
  //Metodo de Obtener Imagenes
  getTutorial(id: string): void {
    this.tutorialService.getTutorialPorId(id)
      .subscribe({
        next: (data) => {
          this.tutorialActual = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
//Metodo de Acutalizar Publicacion
  updatePublicado(status: boolean): void {
    const data = {
      titulo: this.tutorialActual.titulo,
      descripcion: this.tutorialActual.descripcion,
      publicado: status
    };

    this.message = '';

    this.tutorialService.actualizarTutorial(this.tutorialActual.id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.tutorialActual.publicado = status;
          this.message = res.message ? res.message : 'El estado ha sido actualizado correctamente!';
        },
        error: (e) => console.error(e)
      });
  }
//Metodo de Actualizar Imagen
  actualizarTutorial(): void {
    this.message = '';

    this.tutorialService.actualizarTutorial(this.tutorialActual.id, this.tutorialActual)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'Este tutorial ha sido actualizado correctamente!';
        },
        error: (e) => console.error(e)
      });
  }
//Metodo de Eliminar Imagen
  eliminarTutorial(): void {
    this.tutorialService.eliminarTutorial(this.tutorialActual.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/tutoriales']);
        },
        error: (e) => console.error(e)
      });
  }

}

