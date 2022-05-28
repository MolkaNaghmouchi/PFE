import { ConnectpointService } from './connectpoint.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class SeanceService {

  public savedSeances:any;
  constructor(private http : HttpClient, private connect:ConnectpointService) { }
  ajout(seance:any){
    return this.http.post(this.connect.apiuri +'auth/seance/add', seance);
 }
 getAll(){
  return this.http.get(this.connect.apiuri+'auth/seance/all');
}


delete(id:any): Observable<any>{
  return this.http.delete(this.connect.apiuri+'auth/seance/delete/'+id);
}

update(id:any,seance:any){
  return this.http.put(this.connect.apiuri+'auth/seance/update/'+ id,seance);
}
getById(id:any){
  return this.http.get(this.connect.apiuri+'auth/seance/find/'+id);
}
}
