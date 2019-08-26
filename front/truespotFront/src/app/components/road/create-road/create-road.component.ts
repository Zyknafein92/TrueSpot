import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {RoadService} from "../../../services/road/roadservice";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {ClimbingRoad} from "../../../../model/climbingRoad";
import {ActivatedRoute, Router} from "@angular/router";
import {AreaService} from "../../../services/area/area.service";


@Component({
  selector: 'app-create-road',
  templateUrl: './create-road.component.html',
  styleUrls: ['./create-road.component.css']
})

export class CreateRoadComponent implements OnInit {

  forms: FormGroup;
  road: ClimbingRoad;
  idTopoRedirect: any;
  idArea: string;
  private sub: any;



  @Input() idAreaFromViewTopo : string;


  constructor(private roadService: RoadService, private formBuilder: FormBuilder,
              private route: ActivatedRoute, private router: Router,
              private areaService: AreaService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.idArea = params['idArea']; // (+) converts string 'id' to a number
    });
    this.initform();
  }

  saveRoad() {
    this.patchValue();
    this.areaService.getArea(this.idAreaFromViewTopo).subscribe( res => this.idTopoRedirect = res.topo.id);

    this.roadService.saveRoad(this.forms)
      .subscribe(
        response => {

          this.router.navigateByUrl("/topo/view-topo/" + this.idTopoRedirect);
          console.log("reponse SAVE: ", response);
        }),
      err => {
        console.log("error: ", err.error.message);
      }

  }

  private initform() {
    console.log("idAreaFromViewTopo from ADD ROAD", this.idAreaFromViewTopo);
    this.forms = this.formBuilder.group(
      {
        name: new FormControl(),
        description: new FormControl(),
        type: new FormControl(),
        number: new FormControl(),
        letter: new FormControl(),
        symbol: new FormControl(),
        idArea : this.idArea
      }
    );
  }

  private patchValue(){
    this.forms.patchValue({
      idArea : this.idArea==null?this.idAreaFromViewTopo:this.idArea
    });
  }
}
