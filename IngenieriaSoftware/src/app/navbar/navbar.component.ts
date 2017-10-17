import { Component, OnInit } from '@angular/core';
import { NodeLabelDraggingTool } from 'gojs/extensionsTS/NodeLabelDraggingTool';

import * as go from 'gojs/release/go';
 declare var $: any;
 declare var jQuery: any;
// declare var go: any;
// declare var myDiagram: go.Diagram;



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
/*
listarProcesos() {
  $(document).ready(function () {
    $('select').material_select();
  });
}

crearDiagramas() {
$ = go.GraphObject.make;
const myModel = $(go.Model);


console.log('pailas Perro');
// tslint:disable:quotemark
const diagram = new go.Diagram("diagramas");
diagram.initialContentAlignment = go.Spot.Center;
diagram.nodeTemplate =
  $(go.Node, "Auto",  // the Shape will go around the TextBlock
    $(go.Shape, "RoundedRectangle", { strokeWidth: 0 },
      // Shape.fill is bound to Node.data.color
      new go.Binding("fill", "color")),
    $(go.TextBlock,
      { margin: 8 },  // some room around the text
      // TextBlock.text is bound to Node.data.key
      new go.Binding("text", "key"))
  );

// but use the default Link template, by not setting Diagram.linkTemplate

// create the model data that will be represented by Nodes and Links
diagram.model = new go.GraphLinksModel(
  [
    { key: "Alpha", color: "lightblue" },
    { key: "Beta", color: "orange" },
    { key: "Gamma", color: "lightgreen" },
    { key: "Delta", color: "pink" }
  ],
  [
    { from: "Alpha", to: "Beta" },
    { from: "Alpha", to: "Gamma" },
    { from: "Beta", to: "Beta" },
    { from: "Gamma", to: "Delta" },
    { from: "Delta", to: "Alpha" }
  ]);




}*/
}

