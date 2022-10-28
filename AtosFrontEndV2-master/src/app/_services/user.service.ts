import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
const API_URL = 'http://localhost:8080/api/test/';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }
  //Metodo para obtener el contenido publico
  getPublicContent(): Observable<any> {
    return this.http.get(API_URL  + 'all', { responseType: 'text' });
  }
    //Metodo para obtener tablero de Usuario
  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }
    //Metodo para obtener el tablero de Moderador
  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }
    //Metodo para obtener el tablero de Admin
  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }
  
}