import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Temas } from 'src/app/modelos/temas.model';
import { TemasService } from 'src/app/services/temas.service';
import * as M from 'materialize-css'


@Component({
  selector: 'app-temasalumnos',
  templateUrl: './temasalumnos.component.html',
  styleUrls: ['./temasalumnos.component.css']
})
export class TemasalumnosComponent implements OnInit {
  @Input() viewMode = false;
  @Input() temasActual: Temas = {
    titulo: '',
    descripcion: '',
    fechaInicio: new Date,
    fechaFin: new Date,
    iniciativa: ''
  };

  message = ''
  constructor(private temasService: TemasService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getTutorial(this.route.snapshot.params["id"]);
    }

    document.addEventListener('DOMContentLoaded', function () {
      var elems = document.querySelectorAll('.collapsible');
      var instances = M.Collapsible.init(elems);
    });

    document.addEventListener('DOMContentLoaded', function () {
      var elems = document.querySelectorAll('.tooltipped');
      var instances = M.Tooltip.init(elems);
    });
  }

  getTutorial(id: string): void {
    this.temasService.get(id).subscribe({
      next: (data) => {
        this.temasActual = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

}
