import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from 'src/app/_services/user.service';import { TokenStorageService } from 'src/app/_services/token-storage.service';

@Component({
  selector: 'app-menu-tutor',
  templateUrl: './menu-tutor.component.html',
  styleUrls: ['./menu-tutor.component.css']
})
export class MenuTutorComponent implements OnInit {
  roles: string[] = [];
  content?: string;
constructor(private userService: UserService, private tokenStorage: TokenStorageService,  private router: Router) { }
ngOnInit(): void {

  if (this.tokenStorage.getToken()===null) {

    window.alert("¡¡No tienes acceso!!"),
    this.router.navigate(["/", "login"])


  }
  this.roles = this.tokenStorage.getUser().roles;
  if(this.roles.includes('ROLE_USER')){
    window.alert("¡¡Acceso denegado si no eres Tutor o Gestor!!")

    this.router.navigate(["/", "user"]).then(() => {
      window.location.reload();
    });

this.userService.getModeratorBoard().subscribe(
data => {
this.content = data;
},
err => {
this.content = JSON.parse(err.error).message;
}
);
}
}}
