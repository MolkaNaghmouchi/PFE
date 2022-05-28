import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';


import { ConnectpointService } from './connectpoint.service';

@Injectable({
  providedIn: 'root'
})
export class PaiementService {

  public savedPaiements:any;

  constructor(private http : HttpClient, private connect:ConnectpointService) { }
  ajout(paiement:any){
    return this.http.post(this.connect.apiuri +'auth/paiement/add', paiement);
 }
 getAll(){
  return this.http.get(this.connect.apiuri+'auth/paiement/all');
}


delete(id:any): Observable<any>{
  return this.http.delete(this.connect.apiuri+'auth/paiement/delete'+id);
}

update(id:any,paiement:any){
  return this.http.put(this.connect.apiuri+'auth/paiement/update/'+ id,paiement);
}
getById(id:any){
  return this.http.get(this.connect.apiuri+'auth/paiement/find/'+id);
}
}
