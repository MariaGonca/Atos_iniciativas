import { Injectable } from '@angular/core';
const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';
@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
  constructor() { }
  //Metodo de Cerrar Sesión
  signOut(): void {
    window.sessionStorage.clear();
  }
  //Metodo de guardar Token
  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    console.log(TOKEN_KEY)
    console.log(token)
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }
  //Metodo de obtener Token
  public getToken(): string | null {
    console.log(TOKEN_KEY)
    return window.sessionStorage.getItem(TOKEN_KEY);

  }
  //Metodo de guardar Usuario
  public saveUser(user: any): void {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }
  //Metodo de obtener Usuario
  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return {};
  }
}