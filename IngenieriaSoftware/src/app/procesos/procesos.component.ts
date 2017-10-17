import { Component, OnInit } from '@angular/core';
declare var $: any;
declare var jQuery: any;
@Component({
  selector: 'app-procesos',
  templateUrl: './procesos.component.html',
  styleUrls: ['./procesos.component.css']
})
export class ProcesosComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  
  listarProcesos() {
    $(document).ready(function () {
      $('select').material_select();
    });
  }
}
