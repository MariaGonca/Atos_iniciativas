import { Component, OnInit } from '@angular/core';
import * as M from "materialize-css";
import { TokenStorageService } from '../_services/token-storage.service';
import Swal, {SweetAlertOptions} from 'sweetalert2';
@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  font1 = '20px'
  font2 = '40px'
  font = true
  private roles: string[] = [];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username?: string;
  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {

    document.addEventListener('DOMContentLoaded', function() {
      var elems = document.querySelectorAll('.dropdown-trigger');
      var instances = M.Dropdown.init(elems);
    });

    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      this.username = user.username;
    }

    document.addEventListener('DOMContentLoaded', function () {
      var elems = document.querySelectorAll('.sidenav');
      var instances = M.Sidenav.init(elems);
    });
  }

  //Metodo de Cerrar Sesion
  logout(): void {


    this.tokenStorageService.signOut();
    Swal.fire(`Cerrando sesion`).then(()=>{
     window.location.reload(); })

  }
  //Metodo de Accesibilidad
  fontSize() {
    this.font = !this.font;
  }

}
