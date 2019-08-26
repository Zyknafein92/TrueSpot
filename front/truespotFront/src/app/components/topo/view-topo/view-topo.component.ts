import {AfterContentChecked, AfterContentInit, AfterViewInit, Component, OnChanges, OnInit} from '@angular/core';
import {ActivatedRoute, Route, Router} from "@angular/router";
import {TopoService} from "../../../services/topo/topo.service";
import {Topo} from "../../../../model/topo";
import {RoadService} from "../../../services/road/roadservice";
import {ClimbingRoad} from "../../../../model/climbingRoad";
import {AreaService} from "../../../services/area/area.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {TokenStorageService} from "../../../services/auth/token-storage.service";
import {DepartmentService} from "../../../services/department/department.service";
import {Department} from "../../../../model/department";
import {ShareService} from "../../../services/share/share.service";
import {UsermessageService} from "../../../services/user.message/usermessage.service";



@Component({
  selector: 'app-view-topo',
  templateUrl: './view-topo.component.html',
  styleUrls: ['./view-topo.component.css']
})
export class ViewTopoComponent implements OnInit {
  private sub: any;
  idTopo: any;
  idTopoHelpToRedirect: any;
  idArea: any;
  idAreaToAdd: any;
  idRoad: any;
  idMessage: any;
  topo : Topo;
  areas: any;
  roads : any;
  messages: any;

  road: ClimbingRoad;
  department: Department;
  departments: Department;
  formRoad: FormGroup;
  formArea: FormGroup;
  formTopo: FormGroup;
  formMessage: FormGroup;

  idAreaFromViewTopo : string;
  idTopoFromViewTopo: string;

  authorities: string;
  pseudo: string;

  roadHelpToRedirect: any

  isAdd:boolean=false;
  isModified:boolean=false;
  constructor( private topoService: TopoService, private departmentService :DepartmentService,
               private areaService: AreaService,private roadService: RoadService,
               private formBuilder: FormBuilder, private route: ActivatedRoute,
               private router: Router, private token: TokenStorageService,
               private shareService: ShareService,
               private userMessageService: UsermessageService) { }

  ngOnInit() {
    this.getParam();
    this.getTopo();
    this.getArea();
    this.initformTopo();
    this.initformRoad();
    this.initformArea();
    this.initformMessage();
    this.initDepartmentList();
    this.getMessages(this.idTopo);
    this.authorities = this.token.getAuthorities();
    this.pseudo = this.token.getPseudo();

  }

  getParam(){
    this.sub = this.route.params.subscribe(params => {
      this.idTopo = params['idTopo'];
      this.idTopoFromViewTopo = this.idTopo;// (+) converts string 'id' to a number
    });
  }

  // INIT FORMULAIRE //

  private initformTopo(){
    this.formTopo = this.formBuilder.group({
      name: new FormControl(),
      department : new FormControl(),
      user: new FormControl(),
      description: new FormControl(),
      nearestCity: new FormControl(),
      carAccess: new FormControl(),
      carParking: new FormControl(),
      accessDescription: new FormControl(),
      nearestHospital: new FormControl(),
      supplyComment: new FormControl(),
      avaible: new FormControl(),
      releaseDate: new FormControl(),
      id: new FormControl(),
      isOfficial : new FormControl(),
    });

  }

  private initformArea(){
    this.formArea = this.formBuilder.group(
      {
        name: new FormControl(),
        description: new FormControl(),
        orientation  : new FormControl(),
        height: new FormControl(),
        idTopo: this.idTopo,
        id: new FormControl()
      }
    );
  }

  private initformRoad() {
    this.formRoad = this.formBuilder.group(
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


  // TOPO //


  getTopo(){
    this.topoService.getTopo(this.idTopo)
      .subscribe(
        response => {
          this.topo = response;
          console.log("TOPOTPTOOTP :", this.topo)
        },
        err => {
          console.log("error: ", err);
        })

  }

  updateTopo(idTopo){
    this.idTopo = idTopo;
    this.topoService.getTopo(this.idTopo).subscribe(
      response => {
        this.formTopo.patchValue({
          name: response.name,
          department: response.department,
          description : response.description,
          nearestCity : response.nearestCity,
          carAccess: response.carAccess,
          carParking: response.carParking,
          accessDescription : response.accessDescription,
          nearestHospital : response.nearestHospital,
          supplyComment : response.supplyComment,
          id: this.idTopo,
          releaseDate: response.releaseDate,
          avaible: response.avaible,
          user: response.user,
        });
        console.log("TOPO to UPDATE:", this.formTopo.value)
      }),
      err => {
        console.log("error: ", err.error.message);
      };

  }

  updateTopoModel(){
    console.log('FORMTOPO:', this.formTopo.value);
    this.topoService.updateTopo(this.formTopo).subscribe(
      response => {
        console.log("Topo UPDDATING: ", response);
        this.router.navigateByUrl("/topo/view-topo/"+ this.formTopo.getRawValue().id);
        this.refreshTopo();
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  deleteTopo(idTopo){
    console.log("ID REMOVTOPO:", this.idTopo);
    this.idTopo = idTopo;
    this.topoService.deleteTopo(this.idTopo).subscribe(
      response => {
        this.router.navigateByUrl("/list-topo");
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  shareTopo(){
    console.log("BONJJOUURRR")
    const shareDto = {"idUserOwner": this.topo.user.pseudo,"idUserReceiver" : this.token.getPseudo(),"idTopo": this.idTopo}
    this.shareService.saveShare(shareDto).subscribe(
      response => {
        this.router.navigateByUrl("/list-topo");
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }
  // DEPARTMENT  //

  private initDepartmentList() {
    this.departmentService.getDepartments().subscribe(
      res => {
        this.departments = res;
      }
    );
  }
  // AREA //
  getArea(){
    this.areaService.getAreas(this.idTopo)
      .subscribe(
        response => {
          this.areas = response;
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }

  getCurrentIdArea(id) {

    console.log(" AREA CURRENT ", id)
    this.idArea = id;
    this.idAreaFromViewTopo = id;
    this.getRoad(id);

    console.log("idAreaFromViewTopo Vieuw", this.idAreaFromViewTopo);
  }


  addArea(idArea) {
    this.initformArea();
    this.isAdd = false;
    this.isModified = true;
    console.log("ID ADDAREA:", idArea)
  }

  updateArea(idArea) {
    this.idArea = idArea;
    this.isAdd = true;
    this.isModified = false;
    console.log("AREA TO ADD:", this.idArea);
    this.areaService.getArea(this.idArea).subscribe(
      response => {
        console.log("Area CURRENT: ", response);
        this.formArea.patchValue({
          topo: response.topo.id,
          name: response.name,
          description: response.description,
          orientation: response.orientation,
          height: response.height,
          id: response.id
        });
        console.log("F CURRENT:", this.formArea.value)
      }),
      err => {
        console.log("error: ", err.error.message);
      };

  }

  saveAreaModal() {
    this.formArea.patchValue({
      idArea: this.idAreaToAdd,
    });
    this.areaService.saveArea(this.formArea)
      .subscribe(
        response => {
          // Si Area = null -> Formulaire création Road
          this.router.navigateByUrl("/topo/view-topo/"+ this.idTopoHelpToRedirect);
          this.refreshArea();
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }

  updateAreaModel(){
    console.log('FORMADD:', this.formArea.value);
    this.idTopoFromViewTopo = this.formArea.getRawValue().idTopo;
    console.log('FORMADD:', this.idTopoFromViewTopo);
    this.areaService.updateArea(this.formArea).subscribe(
      response => {
        console.log("Area UPDDATING: ", response);
        this.router.navigateByUrl("/topo/view-topo/"+  this.idTopoFromViewTopo);
        this.refreshArea();
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  deleteArea(idArea) {

    this.idArea = idArea;
    this.areaService.deleteArea(this.idArea).subscribe(
      response => {
        this.router.navigateByUrl("/topo/view-topo/"+ this.idTopo);
        this.refreshArea()
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  // ROAD //

  addRoad(area){
    this.initformRoad();
    console.log("ID AREA:", area);
    this.isAdd = false;
    this.isModified = true;
    this.idAreaToAdd = area.id;
    this.idTopoHelpToRedirect  = area.topo.id
  }

  updateRoad(idRoad) {
    this.idRoad = idRoad;
    this.isAdd = true;
    this.isModified = false;
    this.roadService.getRoad(this.idRoad).subscribe(
      response => {
        console.log("ROAD CURRENT: ", response);
        this.formRoad.patchValue({
          name: response.name,
          description:response.description,
          type:response.type,
          number: response.number,
          letter: response.letter,
          symbol: response.symbol,
          idArea : response.area.id,
          id: response.id
        });
      }),
      err => {
        console.log("error: ", err.error.message);
      };
    console.log("F CURRENT:", this.formRoad.value)

  }
  updateRoadModel(){
    this.roadService.getRoad(this.formRoad.getRawValue().id).subscribe(
      response => {
        console.log("ID TOOTPTOTPTOTP getRoad ", response)
        this.roadHelpToRedirect = response;
      }),
      err => {
        console.log("error: ", err.error.message);
      };

    console.log("ROAD UPDDATING: ", this.formRoad.getRawValue().id);
    this.roadService.updateRoad(this.formRoad).subscribe(
      response => {
        // @ts-ignore

        this.router.navigateByUrl("/topo/view-topo/"+ this.roadHelpToRedirect.area.topo.id);
        this.refreshRoad();
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  deleteRoad(idRoad) {

    this.idRoad = idRoad;
    console.log("id:", this.idRoad);
    this.roadService.getRoad(this.idRoad).subscribe(
      response => {
        console.log("ID TOOTPTOTPTOTP getRoad ", response)
        this.roadHelpToRedirect = response;
      }),
      err => {
        console.log("error: ", err.error.message);
      };

    this.roadService.deleteRoad(this.idRoad).subscribe(
      response => {
        this.router.navigateByUrl("/topo/view-topo/"+ this.roadHelpToRedirect.area.topo.id);
        this.refreshRoad();
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  saveRoadModal() {
    this.formRoad.patchValue({
      idArea: this.idAreaToAdd,
    });
    this.roadHelpToRedirect = this.formRoad.getRawValue().id.value;
    console.log("save roadHelpToRedirect", this.roadHelpToRedirect);
    this.roadService.saveRoad(this.formRoad)
      .subscribe(
        response => {
          this.refreshRoad();
          this.router.navigateByUrl("/topo/view-topo/"+ this.roadHelpToRedirect);
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

  // MESSAGE //

  getMessages(id) {
    console.log("ID TOTPO MESSAGE COMPONEN ", id)
    this.userMessageService.getAllMessageByTopoID(id)
      .subscribe(
        response => {
          this.messages = response;
          console.log("Messages: ", response);
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }

  updateMessage(id) {
    this.idMessage = id;
    this.userMessageService.getUserMessage(this.idMessage).subscribe(
      response => {
        console.log("Message CURRENT ID: ", response);
        this.formMessage.patchValue({
          user: response.user,
          message:  response.message,
          date:  response.date,
          topo:  response.topo,
          id: response.id
        });
        console.log("updateMessage IN :", this.formMessage.value)
      }),
      err => {
        console.log("error: ", err.error.message);
      };

    console.log("updateMessage END :", this.formMessage.value)

  }

  private initformMessage() {
    this.formMessage = this.formBuilder.group(
      {
        id: new FormControl(),
        message: new FormControl(),
        user:  new FormControl(),
        date:  new FormControl(),
        topo:  this.topo,
      }
    );

    console.log("initformMessage :", this.formMessage.value)
  }


  updateMessageModel(){
    console.log("Message update: ", this.formMessage.value);

    this.userMessageService.updateUserMessage(this.formMessage).subscribe(
      response => {
        // @ts-ignore
        console.log("Message UPDDATING: ", response);
        this.router.navigateByUrl("/topo/view-topo/"+ this.idTopoHelpToRedirect);
        this.refreshMessages();
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  deleteMessage(id: any) {
    console.log("Message delete: ", id);
    this.userMessageService.deleteUserMessage(id)
      .subscribe(
        response => {
          this.refreshMessages();
          this.messages = response;
          console.log("Messages: ", response);
        }),
      err => {
        console.log("error: ", err.error.message);
      }
  }
  // UTILITAIRE //

  refreshArea(){
    this.getArea();
  }
  refreshTopo(){
    this.getTopo();
  }

  refreshRoad(){
    this.getRoad(this.idArea);
  }
  refreshMessages(){
    console.log("REFR MESSAGE")
    this.getMessages(this.idTopo);
  }

}
