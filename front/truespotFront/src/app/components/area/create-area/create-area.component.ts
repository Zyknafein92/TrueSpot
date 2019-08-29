import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Area} from "../../../../model/area";
import {AreaService} from "../../../services/area/area.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PushRouteService} from "../../../services/pushRoute/push-route.service";


@Component({
  selector: 'app-create-area',
  templateUrl: './create-area.component.html',
  styleUrls: ['./create-area.component.css']
})
export class CreateAreaComponent implements OnInit {

  forms: FormGroup;
  area: Area;
  idTopo: string;
  private sub: any;

  @Input() idTopoFromViewTopo : string;

  constructor(private areaService:AreaService, private formBuilder: FormBuilder,
              private route: ActivatedRoute,private router: Router, private pushRouteService: PushRouteService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.idTopo = params['idTopo']; // (+) converts string 'id' to a number
    });
    this.initForm();
  }

  saveArea() {
    console.log(this.forms.value);
    this.areaService.saveArea(this.forms)
      .subscribe(
        response => {
          // @ts-ignore

          console.log("PREVIOUS URL: ", this.pushRouteService.getPreviousUrl());

          if ("/topo/topo/add-topo/" == this.pushRouteService.getPreviousUrl()) {
            console.log(" /topo/topo/add-topo/ ");
           // this.router.navigateByUrl("/topo/road/add-road/"+response.id)
            // @ts-ignore
            this.pushRouteService.navigateByUrl("/topo/road/add-road/"+response.id);
          } else if ("/topo/view-topo/"+this.idTopo == this.pushRouteService.getPreviousUrl()) {
            console.log("/topo/view-topo/");
            this.pushRouteService.navigateByUrl("/topo/view-topo/"+this.idTopo);
          }else{
            this.pushRouteService.navigateByUrl("/topo/view-topo/"+this.idTopo);

          }

          console.log("response: ", response);
        },
        err => {
          console.log("error: ", err.error.message);
        })
  }

  initForm(){
    this.forms = this.formBuilder.group(
      {
        name: new FormControl(),
        description: new FormControl(),
        orientation  : new FormControl(),
        height: new FormControl(),
        idTopo: this.idTopo,
      }
    );
  }

}
