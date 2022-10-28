import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../modelos/user';
import { map } from 'rxjs/operators';
const AUTH_API = 'http://localhost:8080/api/auth/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private baseUrl: string = 'http://localhost:8080/api/auth';
  private urlEndPoint: string = 'http://localhost:8080/api/auth/users/filtro';
  constructor(private http: HttpClient) { }
  //Metodo Login
  login(username: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      username,
      password
    }, httpOptions);
  }

  getIniciativasByUsername(username: any): Observable<User[]>{
    return this.http.get<User[]>(`${this.urlEndPoint}/byName?username=${username}`).pipe(
      map( (Response) => Response as User[])
    );
  }
  getFiltros(center: any, username: any, apellidos: any, u: any, location:any, iniciativa: any): Observable<User[]>{
    if(iniciativa === null){
      return this.http.get<User[]>(`${this.baseUrl}/users/filtroSin?center=${center}&username=${username}&apellidos=${apellidos}&u=${u}&location=${location}`).pipe(
        map( (Response) => Response as User[])
      );

    }else{
      return this.http.get<User[]>(`${this.baseUrl}/users/filtro?center=${center}&username=${username}&apellidos=${apellidos}&u=${u}&location=${location}&idIniciativa=${iniciativa.idIniciativa}`).pipe(
        map( (Response) => Response as User[])
      );
    }
  }


  public lista(): Observable<User[]> {
    return this.http.get<User[]>(`http://localhost:8080/api/auth/lista`);
  }
  getEmployeeById(id: number): Observable<User>{
    return this.http.get<User>(`http://localhost:8080/api/auth/users/${id}`);
  }

  public update(id: number, user: User): Observable<any> {
    return this.http.put<any>(`http://localhost:8080/api/auth/update/${id}`, user);
  }
  //Metodo Register
  public delete(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/auth/delete/${id}`);
  }
register(user:User): Observable<any> {
  return this.http.post(AUTH_API +'signup', user);
  }
  }


