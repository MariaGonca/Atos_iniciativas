import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Iniciativa } from 'src/app/modelos/iniciativa';
import { User } from 'src/app/modelos/user';
import { IniciativasService } from 'src/app/services/iniciativas.service';
import { AuthService } from 'src/app/_services/auth.service';
import { TokenStorageService } from 'src/app/_services/token-storage.service';

@Component({
  selector: 'app-edicion-user',
  templateUrl: './edicion-user.component.html',
  styleUrls: ['./edicion-user.component.css']
})
export class EdicionUserComponent implements OnInit {
  id: number;
  user: User = new User();
  currentUser: any;
  activatedRoute: any;
  isSuccessful = false;

  iniciativas: Iniciativa[];
  isSignUpFailed = false;
  constructor(private auth: AuthService,private tokenStorage: TokenStorageService,  private route: ActivatedRoute, private router: Router, private iniciativaService: IniciativasService) { }

  ngOnInit(): void {

    if (this.tokenStorage.getToken()===null) {

      window.alert("¡¡No tienes acceso!!"),
      this.router.navigate(["/", "login"])


    }

    this.iniciativaService.getIniciativasAll().subscribe(
      (iniciativas)=> {
        this.iniciativas = iniciativas
      });

    this.id = this.route.snapshot.params['id'];
    this.auth.getEmployeeById( this.id).subscribe(
      data => {
        this.user = data;

      }
    )
  }
getIniciativasAll(): void {
      this.iniciativaService.getIniciativasAll().subscribe(
        (iniciativas)=> {
          this.iniciativas = iniciativas
        }
      );}
  onUpdate(): void {
    this.auth.update(this.id, this.user).subscribe(
      data => {
        window.alert("Usuario Actualizado")
        this.router.navigate(['/admin']);
      }
      );
    }







}

