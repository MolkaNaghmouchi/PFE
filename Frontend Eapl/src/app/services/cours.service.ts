import { getTestBed } from '@angular/core/testing';
import { cour } from 'src/app/pages/Model/cour';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ConnectpointService } from './connectpoint.service';

@Injectable({
  providedIn: 'root'
})
export class CoursService {

  public savedCours:any;
  constructor(private http : HttpClient, private connect:ConnectpointService) { }
  ajout(cour:any){
    return this.http.post('http://localhost:8080/auth/cour/add', cour);
 }

getAll(){
  return this.http.get(this.connect.apiuri+'auth/cour/all');
}
delete(id:any){
  return this.http.delete(this.connect.apiuri+'auth/cour/delete/'+id);
}

update(id:any,cour:any){
  return this.http.put(this.connect.apiuri+'auth/cour/update/'+ id,cour);
}
getById(id:any){
  return this.http.get(this.connect.apiuri+'auth/cour/find/'+id);
}

}

