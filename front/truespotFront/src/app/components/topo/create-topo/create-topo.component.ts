import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Topo} from "../../../../model/topo";
import {TopoService} from "../../../services/topo/topo.service";

@Component({
  selector: 'app-create-topo',
  templateUrl: './create-topo.component.html',
  styleUrls: ['./create-topo.component.css']
})
export class CreateTopoComponent implements OnInit {

  forms: FormGroup;
  topo: Topo;


  constructor(private topoService: TopoService, private formBuilder: FormBuilder){
  }

  ngOnInit() {
    this.initForm();
  }

  saveTopo() {
    console.log("formsformsformsformsformsformsformsforms")
    console.log(this.forms.value)
    this.topoService.saveTopo(this.forms)
      .subscribe(
        response => this.forms)

  }

  private initForm() {
    this.forms = this.formBuilder.group({
        name: new FormControl(),
        department: new FormControl()
        //user //todo: Une fois l'auth fait, rajouter l'utilisateur et photo ?
      });
  }



}
