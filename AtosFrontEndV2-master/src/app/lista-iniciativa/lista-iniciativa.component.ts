import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Iniciativa } from '../modelos/iniciativa';
import { IniciativasService } from '../services/iniciativas.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-lista-iniciativa',
  templateUrl: './lista-iniciativa.component.html',
  styleUrls: ['./lista-iniciativa.component.css']
})
export class ListaIniciativaComponent implements OnInit {

  roles: string[] = [];
  op_activacion: FormGroup;

  iniciativas: Iniciativa[] | undefined;
  tituloIniciativa = '';
  descripcion = '';
  inicio = '';
  fin = '';
  activa = true;

  constructor(private userService: UserService, private tokenStorage: TokenStorageService,private iniciativaService : IniciativasService, private router: Router) { }

  ngOnInit(): void {

    if (this.tokenStorage.getToken()===null) {

      window.alert("¡¡No tienes acceso!!"),
      this.router.navigate(["/", "login"])


    }

    this.iniciativaService.getIniciativasActivas().subscribe(
      (iniciativas)=> {
        this.iniciativas = iniciativas
      }
    );


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


//Limpiar campos
  handleClear(){
    this.tituloIniciativa = '';
    this.descripcion = '';
    this.inicio = '';
    this.fin = '';
  }


//Muestra todas las iniciativas de la BBDD
  getIniciativasAll(): void {
    this.iniciativaService.getIniciativasAll().subscribe(
      (iniciativas)=> {
        this.iniciativas = iniciativas
        if (iniciativas.length === 0){
          Swal.fire('No hay registros')
        }
      }
    );
  }

  //Muestra todas las iniciativas activas de la BBDD
  getIniciativasActivas(): void {
    this.iniciativaService.getIniciativasActivas().subscribe(
      (iniciativas)=> {
        this.iniciativas = iniciativas
      }
    );
  }

  //Muestra todas las iniciativas inactivas de la BBDD
    getIniciativasInactivas(): void {
      this.iniciativaService.getIniciativasInactivas().subscribe(
        (iniciativas)=> {
          this.iniciativas = iniciativas
        }
      );
    }
/////////////////////////////////////////////
    getIniciativasByTituloIniciativa(): void {
      this.iniciativaService.getIniciativasByTituloIniciativa(this.tituloIniciativa).subscribe(
        (iniciativas)=> {
          this.iniciativas = iniciativas
        }
      );
    }

    getIniciativasByDescripcion(): void {
      this.iniciativaService.getIniciativasByDescripcion(this.descripcion).subscribe(
        (iniciativas)=> {
          this.iniciativas = iniciativas
        }
      );
    }

    getIniciativasByFin(): void {
      this.iniciativaService.getIniciativasByFin(this.fin).subscribe(
        (iniciativas)=> {
          this.iniciativas = iniciativas
        }
      );
    }

    getIniciativasByInicio(): void {
      this.iniciativaService.getIniciativasByInicio(this.inicio).subscribe(
        (iniciativas)=> {
          this.iniciativas = iniciativas
        }
      );
    }

    getIniciativasByTituloIniciativaAndDescripcionAndInicioAndFinAndActiva(): void {

      this.iniciativaService.getIniciativasByTituloIniciativaAndDescripcionAndInicioAndFinAndActiva(this.tituloIniciativa, this.descripcion, this.inicio, this.fin, this.activa).subscribe(
        (iniciativas)=> {
          this.iniciativas = iniciativas
          console.log(this.inicio)
          console.log(iniciativas)
          if (iniciativas.length === 0){
            Swal.fire('No hay registros que coincidan con los filtros indicados')
          }
        }
      );
    }

  //Cambia el valor del atributo activa de una iniciativa
  setActiva(iniciativa: Iniciativa): void{
    this.iniciativaService.setActiva(iniciativa).subscribe();
    window.location.reload();
  }

  delete(iniciativa: Iniciativa): void {
        this.iniciativaService.delete(iniciativa.idIniciativa).subscribe();
        this.iniciativaService.getIniciativasAll().subscribe(
          (iniciativas)=> {
            this.iniciativas = iniciativas
          }
        );
    }

  //Borra o desactiva iniciativa dependiendo del booleano de la lista de temas
  deleteOrDeactivate(iniciativa: Iniciativa):void{
    let vac: boolean;
    this.iniciativaService.getTemasIniciativas(iniciativa.idIniciativa).subscribe(
      (boolean)=> {
        vac = boolean
        console.log(iniciativa)
  if(vac===true){
      this.iniciativaService.delete(iniciativa.idIniciativa).subscribe();
      Swal.fire('iniciativa borrada ', `La iniciativa ${iniciativa.tituloIniciativa} ha sido borrada!`)
      console.log(iniciativa)
     }else{
      this.iniciativaService.setActiva(iniciativa).subscribe();
      Swal.fire('iniciativa desactivada ', `La iniciativa ${iniciativa.tituloIniciativa} ha sido desactivada, ya que tiene temas asociados!`)
      console.log(iniciativa)
     }
    setTimeout(() => {
      window.location.reload();
    }, 4200);

      }
    );
  }
}
