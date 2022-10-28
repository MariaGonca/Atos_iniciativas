import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import Swal from 'sweetalert2';
import { catchError, map } from 'rxjs/operators';
import { Temas } from '../modelos/temas.model';
import { Iniciativa } from '../modelos/iniciativa';

@Injectable({
  providedIn: 'root'
})
export class TemasService {
  httpHeaders: HttpHeaders | { [header: string]: string | string[]; };
  router: any;
  constructor(private http: HttpClient) { }

  private baseUrl: string = 'http://localhost:8080/api/temas';


  getTemasAll(): Observable<Temas[]>{
    return this.http.get<Temas[]>(this.baseUrl).pipe(
      map( (Response) => Response as Temas[])
    );
  }
  getTemasByTitulo(titulo: any): Observable<Temas[]>{
    return this.http.get<Temas[]>(`${this.baseUrl}/byTitulo?titulo=${titulo}`).pipe(
      map( (Response) => Response as Temas[])
    );
  }

  getTemasByDescripcion(descripcion: any): Observable<Temas[]>{
    return this.http.get<Temas[]>(`${this.baseUrl}/byDescripcion?descripcion=${descripcion}`).pipe(
      map( (Response) => Response as Temas[])
    );
  }

  getTemasByInicio(inicio: any): Observable<Temas[]>{
    return this.http.get<Temas[]>(`${this.baseUrl}/byInicio?inicio=${inicio}`).pipe(
      map( (Response) => Response as Temas[])
    );
  }

  getTemasByFin(fin: any): Observable<Temas[]>{
    return this.http.get<Temas[]>(`${this.baseUrl}/byFin?fin=${fin}`).pipe(
      map( (Response) => Response as Temas[])
    );
  }

  getTemasByIniciativa(iniciativa: Iniciativa): Observable<Temas[]>{
    return this.http.get<Temas[]>(`${this.baseUrl}/byIniciativa?iniciativa=${iniciativa}`).pipe(
      map( (Response) => Response as Temas[])
    );
  }

  getTemasByTituloAndDescripcionAndInicioAndFin(titulo: any, descripcion: any, inicio: any, fin: any, iniciativa: any): Observable<Temas[]>{
    if(iniciativa === null){
      return this.http.get<Temas[]>(`${this.baseUrl}/filtroWithoutIniciativa?titulo=${titulo}&descripcion=${descripcion}&inicio=${inicio}&fin=${fin}`).pipe(
        map( (Response) => Response as Temas[])
      );
   
    }else{
      return this.http.get<Temas[]>(`${this.baseUrl}/filtro?titulo=${titulo}&descripcion=${descripcion}&inicio=${inicio}&fin=${fin}&iniciativa=${iniciativa.idIniciativa}`).pipe(
        map( (Response) => Response as Temas[])
      );
    }
  }

  create(temas: Temas): Observable<Temas>{
    console.log("Aqui si va", this.baseUrl)
    return this.http.post(this.baseUrl, temas, {headers: this.httpHeaders}).pipe(
      map( (response: any) => response.temas as Temas),
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire( e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  getTema(idTema: any): Observable<Temas>{
    return this.http.get<Temas>(`${this.baseUrl}/${idTema}`).pipe(
      catchError(e => {
        this.router.navigate(['/listaTemas']);
        console.error(e.error.mensaje);
        Swal.fire('Error al editar', e.error.mensaje, 'error');
        return throwError(e);
      })
    )
  }

  update(temas: Temas): Observable<any>{
    return this.http.put<any>(`${this.baseUrl}/${temas.idTema}`, temas, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire( e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  
  delete(idTema: any): Observable<Temas>{
    return this.http.delete<Temas>(`${this.baseUrl}/${idTema}`, {headers: this.httpHeaders}).pipe(
      catchError(e => {
        console.log(e.error.mensaje);
        Swal.fire('Error al eliminar el tema', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }


//---------------------------------//
//getIniciativasTemas(idTema: any): Observable<boolean>{
  //return this.http.get<boolean>(`${this.baseUrl}/${idTema}/iniciativa`)
//}

}