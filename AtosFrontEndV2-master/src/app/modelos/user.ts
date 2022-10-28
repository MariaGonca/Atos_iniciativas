import { Iniciativa } from "./iniciativa";

export class User {
  username: string;
  email: string;
  password: string;
  apellidos: string;
  u:string;
  location: string;
 teacher: string;
 nameGroupTeams: string;
 groupProyect: string;
 center: string;
 finFCT: string;
 dni:string;
 fechaNacimiento:string;
 fechaFCT: string;
 tipo: string;
 po: string;
 positionId: string;
 rr: string;
 rolea:string;
 becas: string;
 phone: string;
 ss: string;
 orgUnit: string;
 convenio: string;
 das: string;
 contacto: string;
 ceco: string;
 sociedad: string;
 emailAtos: string;
 iniciativaUser: Iniciativa = null;

 constructor(){
  this.username=""
  this.email=""
  this.password=""
  this.apellidos=""
  this.u=""
  this.location=""
  this.teacher=""
  this.nameGroupTeams=""
  this.groupProyect=""
  this.center=""
  this.finFCT=""
 this.dni=""
 this.fechaNacimiento=""
 this.fechaFCT=""
 this.tipo=""
 this.po=""
 this.positionId=""
 this.rr=""
 this.rolea=""
 this.becas=""
 this.phone=""
 this.ss=""
 this.orgUnit=""
 this.convenio=""
 this.das=""
 this.contacto=""
 this.ceco=""
 this.sociedad=""
 this.emailAtos=""
 }
}
