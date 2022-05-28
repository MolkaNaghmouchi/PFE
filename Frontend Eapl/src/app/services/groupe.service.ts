import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ConnectpointService } from './connectpoint.service';

@Injectable({
  providedIn: 'root'
})
export class GroupeService {

  constructor(private http : HttpClient, private connect:ConnectpointService) { }
  ajout(groupe:any){
    return this.http.post(this.connect.apiuri +'auth/groupe/add', groupe);
 }
 getAll(){
  return this.http.get(this.connect.apiuri+'auth/groupe/all');
}
delete(id:any): Observable<any>{
  return this.http.delete(this.connect.apiuri+'auth/groupe/delete/'+id);
}

update(id:any,groupe:any){
  return this.http.put(this.connect.apiuri+'auth/groupe/update/'+ id,groupe);
}
getById(id:any){
  return this.http.get(this.connect.apiuri+'auth/groupe/find/'+id);
}

}
