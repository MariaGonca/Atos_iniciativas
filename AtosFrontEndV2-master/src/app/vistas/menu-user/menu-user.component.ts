import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/_services/token-storage.service';

import { UserService } from 'src/app/_services/user.service';
@Component({
  selector: 'app-menu-user',
  templateUrl: './menu-user.component.html',
  styleUrls: ['./menu-user.component.css']
})
export class MenuUserComponent implements OnInit {

  content?: string;
  constructor(private userService: UserService, private tokenStorage: TokenStorageService,  private router: Router) { }
  ngOnInit(): void {

    if (this.tokenStorage.getToken()===null) {

      window.alert("¡¡No tienes acceso!!"),
      this.router.navigate(["/", "login"])


    }
  this.userService.getUserBoard().subscribe(
  data => {
  this.content = data;
  },
  err => {
  this.content = JSON.parse(err.error).message;
  }
  );
  }
  }
