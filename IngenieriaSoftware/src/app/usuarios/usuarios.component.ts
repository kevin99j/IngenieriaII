
import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
declare var $: any;
declare var jQuery: any;

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
   // tslint:disable:no-inferrable-types
 form = false;
 tabla = false;
 form2 = false;
 tabla2 = false;
 avisoEliminar = false;
 usuario: object= {};
 nombre: string = '';
 apellido: string = '';
 nickName: string = '' ;
 password: string = '';
 email: string = '';
 rol: string = '';

user: object = { nombre: '', apellido: '', nickName: '', password: '', email: '', rol: '' };
 usuarios: Array<object>= [];

  constructor(private http: Http) {
}

  ngOnInit() {
this.ListaUsuarios();
  }
  listarUsuarios() {
    const temp: string = '' ;
    $(document).ready(function () {
      $('select').material_select();
    });
  }
  mostrarFormulario() {
this.form = true;
this.tabla = false;
this.form2 = false;
this.tabla2 = false;
this.user = {};
 }
  ocultarForm() {
    this.form = false;
    this.form2 = false;
    this.avisoEliminar = false;
    this.tabla2 = false;
    this.user = {};
  }
public ListaUsuarios() {
  const _url = 'http://localhost:8080/IngenieriaWs/rest/usuarioController/consultarUsuarios';

  this.http.get(_url).subscribe((res: Response) => {
    const usuarioResult = res.json();

for (const user of usuarioResult){
 this.usuario = user;
this.usuarios.push(this.usuario);
}
});
}

public crearUsuario() {
this.user = {};
const _url = 'http://localhost:8080/IngenieriaWs/rest/usuarioController/crearUsuarios';
this.http.post(_url, this.user).subscribe((res: Response) => res.json());
console.log(this.user);
this.form = false;
this.user = {};


}
public modificarUsuario() {
  const _url = 'http://localhost:8080/IngenieriaWs/rest/usuarioController/modificarUsers';
  this.http.post(_url, this.user).subscribe((res: Response) => res.json());
  this.form = false;
}

public eliminarUsuario () {
  const _url = 'http://localhost:8080/IngenieriaWs/rest/usuarioController/eliminarUsers';
  this.http.post(_url , this.user ).subscribe((res: Response) => res.json());
  this.avisoEliminar = false;
}

enviarUsers() {
  const _url = 'http://localhost:8080/Rusa/rest/control/crearUsuario';
  console.log(this.user);
  this.http.post('http://localhost:8080/Rusa/rest/control/crearUsuario', this.user).subscribe((res: Response) => res.json());



}
mostrarTabla() {
  this.tabla = true;
  this.form = false;
  this.form2 = false;
  this.avisoEliminar = false;
  this.tabla2 = false;
}

modificarUsuarioForm(usuario) {
  this.user = usuario;
  this.form = false;
this.tabla = false;
  this.avisoEliminar = false;
  this.tabla2 = false;
this.form2 = true;
}
eliminarUsuarioForm(usuario) {
this.user = usuario;
this.avisoEliminar = true ;
this.form = false;
this.tabla = false;
this.form2 = false;

}
formularioEliminar () {
  this.form = false;
  this.form2 = false;
  this.tabla = false;
  this.tabla2 = true;
  this.avisoEliminar = false;

}

}
