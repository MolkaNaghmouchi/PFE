import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';



const httpOptions = {
     headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private signupUrl = 'http://localhost:8080/auth/Register';
  private loginUrl =  'http://localhost:8080/auth/signIn';


  constructor(private http: HttpClient) {
  }

  attemptAuth(credentials: any): Observable<any> {
    return this.http.post(this.loginUrl, credentials, httpOptions);
  }

  // SignUpInfo(name,username,email,role,password)
  Register(info: any): Observable<any> {
    return this.http.post(this.signupUrl, info);
  }
  
  
  
 
}

