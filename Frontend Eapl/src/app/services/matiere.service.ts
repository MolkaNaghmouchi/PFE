import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConnectpointService } from './connectpoint.service';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  constructor(private http :HttpClient, private connect:ConnectpointService) { }
  ajout(matiere:any){
    return this.http.post(this.connect.apiuri +'matiere/add', matiere);
 }

 getAll(){
  return this.http.get(this.connect.apiuri+'matiere/all');
}


delete(id:any){
  return this.http.delete(this.connect.apiuri+'matiere/'+id)
}
update(id:any,user:any){
  return this.http.put(this.connect.apiuri+'matiere/update/'+ id,user);
}
getById(id:any){
  return this.http.get(this.connect.apiuri+'matiere/'+id);
}




 }


