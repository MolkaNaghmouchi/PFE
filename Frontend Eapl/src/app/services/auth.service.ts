import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConnectpointService } from './connectpoint.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http:HttpClient, private endpoint : ConnectpointService) { }

  login(user:any){
    return this.http.post(this.endpoint.apiuri+'auth/signIn',user);
  }
Register(user:any){
    return this.http.post(this.endpoint.apiuri+'auth/Register',user);
  }
  
  isLoggedIn(){
    let token= localStorage.getItem('token');
    if(token){
      return true;
    }else{
      return false;
    }
  }
  
  
  getUserData(){
  
    let token = localStorage.getItem('token');
  
    if(token){
  
      let data = JSON.parse( window.atob( token.split('.')[1] ) )
      console.log(data);
  
      return data;
  
  
    }
  }
  getformateurData(){
  
    let token = localStorage.getItem('tknform');
  
    if(token){
  
      let data = JSON.parse( window.atob( token.split('.')[1] ) )
      return data;
  
  
    }
  }
}
  