import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Temas } from 'src/app/modelos/temas.model';
import { TemasService } from 'src/app/services/temas.service';
import Swal from 'sweetalert2';
import { Iniciativa } from '../modelos/iniciativa';
import { IniciativasService } from '../services/iniciativas.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-lista-temas',
  templateUrl: './lista-temas.component.html',
  styleUrls: ['./lista-temas.component.css']
})

export class ListaTemasComponent implements OnInit {

  roles: string[] = [];

  iniciativas: Iniciativa[];
  temas: Temas[] | undefined;
  titulo = '';
  descripcion = '';
  inicio = '';
  fin = '';
  iniciativa = null;

  constructor(private userService: UserService, private tokenStorage: TokenStorageService,private temasService : TemasService, private router: Router, private iniciativaService: IniciativasService) { }

  ngOnInit(): void {
    
  this.getTemasAll();

    if (this.tokenStorage.getToken()===null) {

      window.alert("¡¡No tienes acceso!!"),
      this.router.navigate(["/", "login"])


    }

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
//Muestra todas los temas de la BBDD
  getTemasAll(): void {
    this.temasService.getTemasAll().subscribe(
      (temas)=> {
        this.temas = temas
        if (temas.length === 0){
          Swal.fire('No hay registros')
        }
      }
    );
  }


//Limpiar campos
handleClear(){
  this.titulo = '';
  this.descripcion = '';
  this.inicio = '';
  this.fin = '';
}
 

 
/////////////////////////////////////////////
    getTemasByTitulo(): void {
      this.temasService.getTemasByTitulo(this.titulo).subscribe(
        (temas)=> {
          this.temas = temas
        }
      );
    }

    getTemasByDescripcion(): void {
      this.temasService.getTemasByDescripcion(this.descripcion).subscribe(
        (temas)=> {
          this.temas = temas
        }
      );
    }

    getTemasByFin(): void {
      this.temasService.getTemasByFin(this.fin).subscribe(
        (temas)=> {
          this.temas = temas
        }
      );
    }

    getTemasByInicio(): void {
      this.temasService.getTemasByInicio(this.inicio).subscribe(
        (temas)=> {
          this.temas = temas
        }
      );
    }

    //getTemasByIniciativa(): void {
      //this.temasService.getTemasByIniciativa(this.iniciativa).subscribe(
        //(temas)=> {
          //this.temas = temas
        //}
      //);
    //}

    getTemasByTituloAndDescripcionAndInicioAndFin(): void { 
      console.log(this.iniciativa)
      this.temasService.getTemasByTituloAndDescripcionAndInicioAndFin(this.titulo, this.descripcion, this.inicio, this.fin, this.iniciativa).subscribe(
        (temas)=> {
          this.temas = temas
          console.log(temas)
          if (temas.length === 0){
            Swal.fire('No hay registros que coincidan con los filtros indicados')
          }
        }
      );
    }

  delete(temas: Temas): void {   
        this.temasService.delete(temas.idTema).subscribe();
        this.temasService.getTemasAll().subscribe(
          (temas)=> {
            this.temas = temas
          }
        );
    }
}
