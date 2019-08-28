import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TopoService} from "../../../services/topo/topo.service";
import {TokenStorageService} from "../../../services/auth/token-storage.service";
import {Topo} from "../../../../model/topo";
import {UserService} from "../../../services/user/user.service";
import {User} from "../../../../model/user";
import {ShareService} from "../../../services/share/share.service";
import {Share} from "../../../../model/share";

@Component({
  selector: 'app-view-mylist-topo',
  templateUrl: './view-mylist-topo.component.html',
  styleUrls: ['./view-mylist-topo.component.css']
})
export class ViewMylistTopoComponent implements OnInit {
  topos : any;
  toposShare: any;
  topo: Topo;
  currentShare: Share;
  currentUser: User;
  usertoShow: User;

  constructor(private route: ActivatedRoute, private topoService: TopoService, private router: Router,
              private token:TokenStorageService, private userService:UserService,
              private shareService:ShareService) {
  }

  ngOnInit() {
    this.getAllMyTopos(this.token);
    this.getAllShareTopoByUser();
  }

  getCurrentUser() {
    this.userService.getProfil(this.token.getPseudo()).subscribe(
      res => {
        this.currentUser = res;
      }
    )
  }

  getAllMyTopos(token : TokenStorageService){
    this.topoService.getTopoByUser(this.token.getPseudo()).subscribe(
      res => {
        this.topos = res;
      }
    )
  }


  getAllShareTopoByUser(){
    this.userService.getProfil(this.token.getPseudo()).subscribe(
      res => {
        this.currentUser = res;
        console.log("CURRENT USER ", this.currentUser);
        this.topoService.getAllShareTopoByUser(this.currentUser.id.toString()).subscribe(
          res => {
            this.toposShare = res;
            console.log("SHARE ", this.toposShare);
          }
        )
      }
    )
  }

  sendIdTopo(id){
    this.router.navigateByUrl("/topo/view-topo/"+id)
  }

  shareTopo(id){
    const shareDTO = {"id": id}
    this.topoService.updateShare(shareDTO).subscribe(
      response => {
        this.router.navigateByUrl("/list-topo");
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  updateTopo(id){
    this.shareService.updateTopo({"id": id}).subscribe(
      response => {
        this.router.navigateByUrl("/list-topo");
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  sendUsertoShow(user){
    this.usertoShow = user;
    console.log(" USERRR ", user)
  }


  findUserShare(id){
    this.shareService.findUserShare(id).subscribe(
      response => {
        this.currentShare = response;
      }),
      err => {
        console.log("error: ", err.error.message);
      };
  }

  sendUsertoShowShare(id){
    console.log(" USERRR sendUsertoShowShare ", id);


    this.shareService.findUserShare(id).subscribe(
      response => {
        this.currentShare = response;
        this.usertoShow = this.currentShare.userReceiver;
        console.log("findUserShare Userddd: ", this.usertoShow);
      }),
      err => {
        console.log("error: ", err.error.message);
      };

  }
}
