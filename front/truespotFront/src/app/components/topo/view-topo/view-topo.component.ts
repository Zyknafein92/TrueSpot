import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Route, Router} from "@angular/router";
import {TopoService} from "../../../services/topo/topo.service";
import {Topo} from "../../../../model/topo";
import {RoadService} from "../../../services/road/roadservice";
import {ClimbingRoad} from "../../../../model/climbingRoad";
import {AreaService} from "../../../services/area/area.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {TokenStorageService} from "../../../services/auth/token-storage.service";



@Component({
  selector: 'app-view-topo',
  templateUrl: './view-topo.component.html',
  styleUrls: ['./view-topo.component.css']
})
export class ViewTopoComponent implements OnInit {
  private sub: any;
  idTopo: any;
  idTopoHelToRedirect: any;
  idArea: any;
  idAreaToAdd: any;
  idRoad: any;
  topo : Topo;
  areas: any;
  roads : any;
  road: ClimbingRoad;

  formAddRoad: FormGroup;
  formUpdateRoad: FormGroup;
  formAddArea: FormGroup;
  formUpdateArea: FormGroup;

  authorities: string;
  pseudo: string;

  isAdd:boolean=false;
  isModified:boolean=false;
  constructor( private topoService: TopoService,
               private areaService: AreaService,private roadService: RoadService,
               private formBuilder: FormBuilder, private route: ActivatedRoute,
               private router: Router, private token: TokenStorageService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.idTopo = params['idTopo']; // (+) converts string 'id' to a number
    });

    this.getTopo();
    this.getArea();
    this.initformAddRoad();
   // this.initformUpdateRoad();


   // this.initformAddArea();
    // this.initformUpdateArea();
    this.authorities = this.token.getAuthorities();
    this.pseudo = this.token.getPseudo();

    console.log("this.authorities ", this.authorities)
  }


  // INIT FORMULAIRE //

  private initformAddArea(){
    this.formAddArea = this.formBuilder.group(
      {
        name: new FormControl(),
        description: new FormControl(),
        orientation  : new FormControl(),
        height: new FormControl(),
        idTopo: this.idTopo,
      }
    );
  }

  private initformAddRoad() {
    this.formAddRoad = this.formBuilder.group(
      {
        name: new FormControl(),
        description: new FormControl(),
        type: new FormControl(),
        number: new FormControl(),
        letter: new FormControl(),
        symbol: new FormControl(),
        idArea : this.idArea,
        id : new FormControl(),
      }
    );
  }


  // private initformUpdateArea(){
  //   this.formUpdateArea = this.formBuilder.group(
  //     {
  //       name: new FormControl(),
  //       description: new FormControl(),
  //       orientation  : new FormControl(),
  //       height: new FormControl(),
  //       idTopo: this.idTopo,
  //     }
  //   );
  // }


  // TOPO //
  getTopo(){
    this.topoService.getTopo(this.idTopo)
      .subscribe(
        response => {
          this.topo = response;
          console.log("TOPO: ", response);
        },
        err => {
          console.log("error: ", err);
        })

  }

  // AREA //
  getArea(){
    this.areaService.getAreas(this.idTopo)
      .subscribe(
        response => {
          this.areas = response;
          console.log("AREAS: ", this.areas);
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }

  getCurrentIdArea(id) {
    this.idArea = id;
    this.getRoad(id);
  }


  addArea(idArea) {
    console.log("ID ADDAREA:", idArea)
  }
  updateArea(idArea) {
    this.idArea = idArea;
    console.log("ID UPDATEAREA:", this.idArea)
  }

  deleteArea(idArea) {
    console.log("ID REMOVEAREA:", idArea)
  }

 // ROAD //
  addRoad(area){
    console.log("ID AREA:", area);
    this.isAdd = false;
    this.isModified = true;
    this.idAreaToAdd = area.id;
    this.idTopoHelToRedirect  = area.topo.id
  }

  updateRoad(idRoad) {

    this.idRoad = idRoad;
    this.isAdd = true;
    this.isModified = false;
    this.roadService.getRoad(this.idRoad).subscribe(
      response => {
        console.log("ROAD CURRENT: ", response);
        this.formAddRoad.patchValue({
          name: response.name,
          description:response.description,
          type:response.type,
          number: response.number,
          letter: response.letter,
          symbol: response.symbol,
          idArea : response.area.id,
          id : response.id
        });
      }),
      err => {
        console.log("error: ", err.error.message);
      };
    console.log("F CURRENT:", this.formAddRoad.value)

  }
  updateRoadModel(){

    console.log("FORM ", this.formAddRoad.value);
    this.roadService.updateRoad(this.formAddRoad).subscribe(
      response => {
        // @ts-ignore
        console.log("ROAD UPDDATING: ", response);

      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  deleteRoad(idRoad: any) {
    this.idRoad = idRoad;
    console.log("id:", this.idRoad);
    this.roadService.deleteRoad(this.idRoad).subscribe(
      response => {
        this.router.navigateByUrl("/topo/view-topo/"+ this.idTopoHelToRedirect);
        console.log("reponse: ", response);
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  saveRoadModal() {
    this.formAddRoad.patchValue({
      idArea: this.idAreaToAdd,
    });
    this.roadService.saveRoad(this.formAddRoad)
      .subscribe(
        response => {
          // @ts-ignore
          $('#addRoad').modal('hide');
          this.router.navigateByUrl("/topo/view-topo/"+ this.idTopoHelToRedirect);
          console.log("reponse: ", response);
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }


  getRoad(id) {
    this.roadService.getRoads(id)
      .subscribe(
        response => {
          this.roads = response;
          console.log("ROADs: ", response);
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }


}
