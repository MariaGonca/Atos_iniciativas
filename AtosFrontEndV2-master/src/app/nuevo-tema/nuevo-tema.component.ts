import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';
import { Temas } from '../modelos/temas.model';
import { TemasService } from '../services/temas.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';
import { IniciativasService } from '../services/iniciativas.service';
import { Iniciativa } from '../modelos/iniciativa';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-nuevo-tema',
  templateUrl: './nuevo-tema.component.html',
  styleUrls: ['./nuevo-tema.component.css']
})
export class NuevoTemaComponent implements OnInit {

  roles: string[] = [];
  iniciativas: Iniciativa[];

  public temas: Temas = new Temas()
  private titulo:string = "Crear tema"

  constructor(private userService: UserService, private tokenStorage: TokenStorageService, private temasService: TemasService, private iniciativaService: IniciativasService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }


    ngOnInit(): void {

      if (this.tokenStorage.getToken()===null) {

        window.alert("¡¡No tienes acceso!!"),
        this.router.navigate(["/", "login"])


      }


      this.cargarTema();

    this.roles = this.tokenStorage.getUser().roles;
    if(this.roles.includes('ROLE_USER')){
      window.alert("¡¡Acceso denegado si no eres Gestor!!")

      this.router.navigate(["home"]).then(() => {
        window.location.reload();
      });


    }else if(this.roles.includes('ROLE_MODERATOR')){
      window.alert("¡¡Acceso denegado si no eres Gestor!!")

      this.router.navigate(["/", "mod"]).then(() => {
        window.location.reload();
      });
    }
    this.iniciativaService.getIniciativasAll().subscribe(
      (iniciativas)=> {
        this.iniciativas = iniciativas
      });
    }

    getIniciativasAll(): void {
      this.iniciativaService.getIniciativasAll().subscribe(
        (iniciativas)=> {
          this.iniciativas = iniciativas
        }
      );
    }

    cargarTema(): void{
      this.activatedRoute.params.subscribe(params => {
        let idTema = params['idTema']
        if(idTema){
          this.temasService.getTema(idTema).subscribe( (temas) => this.temas = temas)
        }
      })
    }


    create(): void{
      console.log(this.temas)
      this.temasService.create(this.temas)
      .subscribe(temas => {
          console.log(this.temas)
          this.router.navigate(['/listaTemas'])
          Swal.fire('Nueva tema', `El tema ${temas.titulo} ha sido creado!`)
        },
        err => {
          console.error('Código del error desde el backend: ', err.status);
          console.error(err.error.errors);
          Swal.fire("Error al crear el tema",err.error.mensaje, "error")
          console.log(this.temas);
        }
      );
    }

    update(): void{
      this.temasService.update(this.temas)
      .subscribe( json => {
        this.router.navigate(['/listaTemas'])
        Swal.fire('Tema actualizado', `${json.mensaje}: ${json.temas.titulo} actualizada!`)
      },
        err => {
          //this.errores = err.error.errors as string[];
          console.error('Código del error desde el backend: ', err.status);
          console.error(err.error.errors);
          Swal.fire("Error al editar el tema",err.error.mensaje, "error")
          console.log(this.temas)
        }
      )
    }
  }

