import { Injectable } from '@angular/core';
import { ListaIniciativaComponent } from '../lista-iniciativa/lista-iniciativa.component';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { Iniciativa } from '../modelos/iniciativa';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class IniciativasService {

  private urlEndPoint: string = 'http://localhost:8080/api/iniciativas';

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})

  constructor(private http: HttpClient, private router: Router) { }

  getIniciativasAll(): Observable<Iniciativa[]>{
    return this.http.get<Iniciativa[]>(this.urlEndPoint).pipe(
      map( (Response) => Response as Iniciativa[])
    );
  }

  getIniciativasActivas(): Observable<Iniciativa[]>{
    return this.http.get<Iniciativa[]>(`${this.urlEndPoint}/activas`).pipe(
      map( (Response) => Response as Iniciativa[])
    );
  }

  getIniciativasInactivas(): Observable<Iniciativa[]>{
    return this.http.get<Iniciativa[]>(`${this.urlEndPoint}/inactivas`).pipe(
      map( (Response) => Response as Iniciativa[])
    );
  }
 
/*----------------------------------*/

  getIniciativasByTituloIniciativa(tituloIniciativa: any): Observable<Iniciativa[]>{
    return this.http.get<Iniciativa[]>(`${this.urlEndPoint}/byTituloIniciativa?tituloIniciativa=${tituloIniciativa}`).pipe(
      map( (Response) => Response as Iniciativa[])
    );
  }

  getIniciativasByDescripcion(descripcion: any): Observable<Iniciativa[]>{
    return this.http.get<Iniciativa[]>(`${this.urlEndPoint}/byDescripcion?descripcion=${descripcion}`).pipe(
      map( (Response) => Response as Iniciativa[])
    );
  }

  getIniciativasByInicio(inicio: any): Observable<Iniciativa[]>{
    return this.http.get<Iniciativa[]>(`${this.urlEndPoint}/byInicio?inicio=${inicio}`).pipe(
      map( (Response) => Response as Iniciativa[])
    );
  }

  getIniciativasByFin(fin: any): Observable<Iniciativa[]>{
    return this.http.get<Iniciativa[]>(`${this.urlEndPoint}/byFin?fin=${fin}`).pipe(
      map( (Response) => Response as Iniciativa[])
    );
  }

  getIniciativasByTituloIniciativaAndDescripcionAndInicioAndFinAndActiva(tituloIniciativa: any, descripcion: any, inicio: any, fin: any, activa: any): Observable<Iniciativa[]>{
    
    return this.http.get<Iniciativa[]>(`${this.urlEndPoint}/filtro?tituloIniciativa=${tituloIniciativa}&descripcion=${descripcion}&inicio=${inicio}&fin=${fin}&activa=${activa}`).pipe(
      map( (Response) => Response as Iniciativa[])
    );
  }

/*................................*/

/*  setActiva(iniciativa: Iniciativa): Observable<any>{
    return this.http.post<any>(`${this.urlEndPoint}/${iniciativa.idIniciativa}`, iniciativa, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        console.log(e.error.mensaje);
        console.error(e.error.mensaje);   
        return throwError(e);
      })
   );
  }*/

    setActiva(iniciativa: Iniciativa): Observable<any>{
    return this.http.post<any>(`${this.urlEndPoint}/${iniciativa.idIniciativa}`, iniciativa, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        console.log(e.error.mensaje);
        console.error(e.error.mensaje);   
        return throwError(e);
      })
   );
  }

  create(iniciativa: Iniciativa): Observable<Iniciativa>{
    return this.http.post(this.urlEndPoint, iniciativa, {headers: this.httpHeaders}).pipe(
      map( (response: any) => response.iniciativa as Iniciativa),
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire( e.error.mensaje, e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  getIniciativa(idIniciativa: any): Observable<Iniciativa>{
    return this.http.get<Iniciativa>(`${this.urlEndPoint}/${idIniciativa}`).pipe(
      catchError(e => {
        this.router.navigate(['/listaIniciativas']);
        console.error(e.error.mensaje);
        Swal.fire('Error al editar', e.error.mensaje, 'error');
        return throwError(e);
      })
    )
  }

  update(iniciativa: Iniciativa): Observable<any>{
    return this.http.put<any>(`${this.urlEndPoint}/${iniciativa.idIniciativa}`, iniciativa, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire( e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  
  delete(idIniciativa: any): Observable<Iniciativa>{
    return this.http.delete<Iniciativa>(`${this.urlEndPoint}/${idIniciativa}`, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        console.log(e.error.mensaje);
        Swal.fire('Error al eliminar la iniciativa', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }


//---------------------------------//
getTemasIniciativas(idIniciativa: any): Observable<boolean>{
  return this.http.get<boolean>(`${this.urlEndPoint}/${idIniciativa}/temas`)
}
//--------------------------------//
}
