import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import Swal from 'sweetalert2';
import { User } from '../modelos/user';
import { Iniciativa } from '../modelos/iniciativa';
import { IniciativasService } from '../services/iniciativas.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public user: User;
  isSuccessful = false;
  isSignUpFailed = false;

  iniciativas: Iniciativa[];
  errorMessage = '';

  constructor(private authService: AuthService,private tokenStorage: TokenStorageService,private router: Router,  private iniciativaService: IniciativasService) {  this.user = new User()}
  ngOnInit(): void {

    if (this.tokenStorage.getToken()===null) {

    window.alert("¡¡No tienes acceso!!"),
    this.router.navigate(["/", "login"])


  }
  this.iniciativaService.getIniciativasAll().subscribe(
    (iniciativas)=> {
      this.iniciativas = iniciativas
    });
  }

  getIniciativasAll(): void {
    this.iniciativaService.getIniciativasAll().subscribe(
      (iniciativas)=> {
        this.iniciativas = iniciativas
      }
    );
  }
  onSubmit(): void {
  this.authService.register( this.user).subscribe(
  data => {
  console.log(data);
  this.isSuccessful = true;
  this.isSignUpFailed = false;
  Swal.fire(`El usuario ${this.user.username} ha sido Creado!`)


  },
  err => {
  this.errorMessage = err.error.message;
  this.isSignUpFailed = true;
  }
  );
  }
  }
