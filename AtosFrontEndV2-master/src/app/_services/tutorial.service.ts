import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tutorial } from '../modelos/tutorial.model';

const baseUrl = 'http://localhost:8080/api/tutoriales';//TOD
@Injectable({
  providedIn: 'root'
})
export class TutorialService {

    constructor(private http: HttpClient) { }
//Metodo para obtener todas las imagenes
  getTodosTutoriales(): Observable<Tutorial[]> {
    return this.http.get<Tutorial[]>(baseUrl);
  }
//Metodo para obtener las imagenes por ID
  getTutorialPorId(id: any): Observable<Tutorial> {
    return this.http.get(`${baseUrl}/${id}`);
  }
//Metodo para Crear Imagen
  crearTutorial(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }
//Metodo para Actualizar Imagen
  actualizarTutorial(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }
//Metodo para Eliminar Imagen
  eliminarTutorial(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }
//Metodo para Eliminar todas las imagenes
  eliminarTodosTutoriales(): Observable<any> {
    return this.http.delete(baseUrl);
  }
//Metodo para buscar por titulo
  findByTitulo(titulo: any): Observable<Tutorial[]> { //title o titulo ??????
    return this.http.get<Tutorial[]>(`${baseUrl}?titulo=${titulo}`);
  }
}
