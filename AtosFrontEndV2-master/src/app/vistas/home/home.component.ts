import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/_services/token-storage.service';
import { UserService } from 'src/app/_services/user.service';
@Component({
selector: 'app-home',
templateUrl: './home.component.html',
styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
content?: string;
constructor(private userService: UserService, private tokenStorage: TokenStorageService,  private router: Router) { }
ngOnInit(): void {
  if (this.tokenStorage.getToken()===null) {

    window.alert("¡¡No tienes acceso!!"),
    this.router.navigate(["/", "login"])


  }
this.userService.getPublicContent().subscribe(
data => {
this.content = data;
},
err => {
this.content = JSON.parse(err.error).message;
}
);
}
}
