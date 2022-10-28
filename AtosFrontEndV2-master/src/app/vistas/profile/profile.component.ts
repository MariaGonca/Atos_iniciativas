import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/_services/token-storage.service';
@Component({
    selector: 'app-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
    currentUser: any;
    constructor(private token: TokenStorageService,  private router: Router, private tokenStorage: TokenStorageService) { }
    ngOnInit(): void {
      if (this.tokenStorage.getToken()===null) {

        window.alert("¡¡No tienes acceso!!"),
        this.router.navigate(["/", "login"])


      }
        this.currentUser = this.token.getUser();
    }
}
