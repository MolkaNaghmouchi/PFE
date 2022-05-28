import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  isSubmit = false;

  isRegistered = false;
  option = '';
  errorMessage = '';
  list: string[]=[]


 formDemo!: FormGroup
  constructor(private fb: FormBuilder,private authSevice: AuthService ,private router: Router) {}

  ngOnInit() {
    this.formDemo = this.fb.group({
      username: ['',Validators.required],
      email: ['',Validators.required,Validators.email],
      firstName: ['',Validators.required],
      lastName: ['',Validators.required],
      Num: ['',Validators.required],
      age: ['',Validators.required],
      adresse: ['',Validators.required],
      genre: ['',Validators.required],
      password: ['',Validators.required],
      role: []
    });
  }
  selectChangeHandler (event: any) {
    //update the ui
    this.option = event.target.value;}

  get form() {
    return this.formDemo.controls;
  }
  onSubmit() {
   /* console.log("Name :- "+this.form.username.value)
    console.log("Email :- "+this.form.email.value)
    console.log("Address1 :- "+this.form.telephone.value)
    console.log("Address2 :- "+this.form.firstname.value)
    console.log("City :- "+this.form.adress.value)
    console.log("State :- "+this.form.lastname.value)*/
    let myForm = {
    'firstName': this.form.firstName.value,
    'lastName':this.form.lastName.value,
    'email':this.form.email.value, 
    'Num':this.form.Num.value,
    'password':this.form.password.value,
    'username':this.form.username.value,
    'adresse':this.form.adresse.value,
    'genre':this.form.genre.value,
    'age':this.form.age.value,
    'role':this.option,
}


    this.isSubmit = true;


    this.authSevice.Register(myForm).subscribe(
      (data: any) => {
        console.log(data);
        this.isRegistered = true;

        this.router.navigateByUrl('login');

      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;

      }
    )
  }


}
