import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Iniciativa } from '../modelos/iniciativa';
import { IniciativasService } from '../services/iniciativas.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-form-iniciativa',
  templateUrl: './form-iniciativa.component.html',
  styleUrls: ['./form-iniciativa.component.css']
})
export class FormIniciativaComponent implements OnInit {

  roles: string[] = [];

  public iniciativa: Iniciativa = new Iniciativa()
  private tituloIniciativa:string = "Crear iniciativa"
  errores: string[];

  constructor(private userService: UserService, private tokenStorage: TokenStorageService, private IniciativasService: IniciativasService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }


    ngOnInit(): void {

      if (this.tokenStorage.getToken()===null) {

        window.alert("¡¡No tienes acceso!!"),
        this.router.navigate(["/", "login"])


      }


      this.cargarIniciativa();

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
    }


    cargarIniciativa(): void{
      this.activatedRoute.params.subscribe(params => {
        let idIniciativa = params['idIniciativa']
        if(idIniciativa){
          this.IniciativasService.getIniciativa(idIniciativa).subscribe( (iniciativa) => this.iniciativa = iniciativa)
        }
      })
    }


    create(): void{
      console.log(this.iniciativa)
      this.IniciativasService.create(this.iniciativa)
      .subscribe(iniciativa => {
          this.router.navigate(['/listaIniciativas'])
          Swal.fire('Nueva iniciativa', `La iniciativa ${iniciativa.tituloIniciativa} ha sido creada!`)
        },
        err => {
        //  if(err.status == 500){
        //      Swal.fire("Error al crear la iniciativa","Titulo ya existente", "error")
       //     }else{
          console.error('Código del error desde el backend: ', err.status);
          console.error(err.error.errors);
          Swal.fire("Error al crear la iniciativa",err.error.mensaje, "error")
          console.log(this.iniciativa);
    //        }
        }
      );
    }

    update(): void{
      this.IniciativasService.update(this.iniciativa)
      .subscribe( json => {
        this.router.navigate(['/listaIniciativas'])
        Swal.fire('Iniciativa actualizada', `${json.mensaje}: ${json.iniciativa.tituloIniciativa} actualizada!`)
      },
        err => {

         /* this.errores = err.error.errors as string[];
          console.error('Código del error desde el backend: ', err.status);
          console.error(err.error.errors);
          console.log(this.iniciativa);*/
      
          console.error('Código del error desde el backend: ', err.status);
          console.error(err.error.errors);
          Swal.fire("Error al editar la iniciativa",err.error.mensaje, "error")
          console.log(this.iniciativa);
       
        }
      )
    }

  }

