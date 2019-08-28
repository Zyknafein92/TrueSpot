import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../../services/user/user.service";
import {User} from "../../../../model/user";
import {Router} from "@angular/router";


@Component({
  selector: 'app-createuser',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  forms: FormGroup;
  user: User;
  files: FileList;
  file_src: string;
  messagError: string;

  constructor(private userService:UserService, private formBuilder: FormBuilder, private router:Router) { }

  ngOnInit() {
    this.initForm();
  }

  saveuser() {
    console.log(this.forms.value);
    this.userService.saveUser(this.forms)
      .subscribe(
        response => {
          this.router.navigateByUrl("/sign-in");
          console.log("response: ", response);
        },
      err => {
        console.log("Error: ", err.error.message);
        this.messagError = err.error.message;
      })
  }

  private initForm(){
    this.forms = this.formBuilder.group(
      {
        firstName: new FormControl(),
        lastName: new FormControl(),
        email: new FormControl('', Validators.compose([
          Validators.required,
          Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
        ])),
        birthDate: new FormControl(),
        phoneNumber: new FormControl('', Validators.compose([
          Validators.required,
          Validators.pattern('^[0-9]{10}$')
        ])),
        gender: new FormControl(),
        pseudo: new FormControl(),
        password: new FormControl(),
        //image: new FormControl()
      }
    );
  }






  // imageChange(input) {
  //   this.file_src = '//placehold.it/200';
  //   // Loop through each picture file
  //   this.files = (input.target.files[0]);
  //
  //   // Create an img element and add the image file data to it
  //   var img = document.createElement('img');
  //   img.src = window.URL.createObjectURL(input.target.files[0]);
  //
  //   // Create a FileReader
  //   var reader = new FileReader();
  //
  //   // Add an event listener to deal with the file when the reader is complete
  //   reader.addEventListener('load', (event: any) => {
  //     // Get the event.target.result from the reader (base64 of the image)
  //     img.src = event.target.result;
  //
  //     // Resize the image
  //     var resized_img = img.src;//this.resize(img);
  //     // Push the img src (base64 string) into our array that we display in our html template
  //     this.file_src = resized_img;
  //     //console.log(' base 64 ' + this.file_src);
  //   }, false);
  //
  //   reader.readAsDataURL(input.target.files[0]);
  //   //}
  // }
  //
  // resize(img, MAX_WIDTH: number = 100, MAX_HEIGHT: number = 100) {
  //   var canvas = document.createElement('canvas');
  //
  //
  //   var width = img.width;
  //   var height = img.height;
  //
  //   if (width > height) {
  //     if (width > MAX_WIDTH) {
  //       height *= MAX_WIDTH / width;
  //       width = MAX_WIDTH;
  //     }
  //   } else {
  //     if (height > MAX_HEIGHT) {
  //       width *= MAX_HEIGHT / height;
  //       height = MAX_HEIGHT;
  //     }
  //   }
  //   canvas.width = width;
  //   canvas.height = height;
  //   var ctx = canvas.getContext('2d');
  //
  //   ctx.drawImage(img, 0, 0, width, height);
  //
  //   var dataUrl = canvas.toDataURL('image/jpeg');
  //   // IMPORTANT: 'jpeg' NOT 'jpg'
  //   return dataUrl;
  // }


}
