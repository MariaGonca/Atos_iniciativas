import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../_services/auth.service';
import Swal, {SweetAlertOptions} from 'sweetalert2';
import { TokenStorageService } from '../_services/token-storage.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  constructor(private authService: AuthService, private tokenStorage: TokenStorageService,private router: Router) { }
  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }else if(this.tokenStorage.getToken()!=null){
      window.alert("Ya estas logeado"),
      this.router.navigate(["/", "home"])
    }
  }
  onSubmit(): void {
    const { username, password } = this.form;
    this.authService.login(username, password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        console.log(this.tokenStorage)
        this.roles = this.tokenStorage.getUser().roles;

        Swal.fire(`Has iniciado sesion como ${username}`).then(()=>{

        if(this.roles.includes('ROLE_USER')){

          this.router.navigate(["/", "user"]).then(() => {
            window.location.reload();
          });


        }else if(this.roles.includes('ROLE_MODERATOR')){

          this.router.navigate(["/", "mod"]).then(() => {
            window.location.reload();
          });
        }else if(this.roles.includes('ROLE_ADMIN')){

          this.router.navigate(["/", "admin"]).then(() => {
            window.location.reload();
          });}})
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );


    this.isLoginFailed = true;

  }
  //Metodo de Recargar Pagina
  reloadPage(): void {
    window.location.reload();
  }
}
