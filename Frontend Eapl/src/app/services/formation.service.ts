import { Injectable } from '@angular/core';

import {HttpClient} from '@angular/common/http';
import { environment } from 'src/environments/environment';

import { ConnectpointService } from './connectpoint.service';

@Injectable({
  providedIn: 'root'
})
export class FormationService {
  constructor(private http :HttpClient, private connect:ConnectpointService) { }
  ajout(matiere:any){
    return this.http.post(this.connect.apiuri +'auth/AddFormation', matiere);
 }

 getAll(){
  return this.http.get(this.connect.apiuri+'auth/GetFormations');
}


delete(id:any){
  return this.http.delete(this.connect.apiuri+'matiere/'+id)
}
update(id:any,user:any){
  return this.http.put(this.connect.apiuri+'auth/ModifyActivity'+ id,user);
}
getById(idFormation:any){
  return this.http.get(this.connect.apiuri+'auth/{id}/'+idFormation);
}




 }
