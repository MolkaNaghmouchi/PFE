import { Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/Auth.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TokenService } from 'src/app/token.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
    result = false;
  myForm: FormGroup;
  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router, private token: TokenService) {
  }


  get form() {
    return this.myForm.controls;
  }

  ngOnInit() {
    

    if (this.token.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.token.getAuthorities();
    }
    this.myForm = this.fb.group({
      username: ['',Validators.required],
      password: ['',Validators.required]

    });
  }
  buildMyForm() {
    throw new Error('Method not implemented.');
  }

  onSubmit() {
    console.log("username :- " + this.form.username.value)
    console.log("password :- " + this.form.password.value)
    
   ;
    let signInfo = {
      'username': this.form.username.value,
      'password': this.form.password.value

    }
    console.log(signInfo);


    this.authService.attemptAuth(signInfo).subscribe(
      data => {
        this.token.saveToken(data.accessToken);
        
        this.token.saveAuthorities(data.authorities);
        this.token.saveUser(data)
        console.log(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.token.getAuthorities();
        this.router.navigateByUrl('session');


      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      }
    );

  }

  reloadPage() {
    window.location.reload();
  }

}
