import { Formation } from './../pages/Model/formation';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { ConnectpointService } from './connectpoint.service';


@Injectable({
  providedIn: 'root'
})
export class FormationsService {

  data: Formation[];
  baseUrl = environment.URL;
  constructor(public http: HttpClient, private connect:ConnectpointService) { }
  read(): Observable<any>{
    return this.http.get(this.baseUrl+'auth/GetFormations');
  }

 insert(data: Formation) {
   return this.http.post(this.baseUrl +'auth/addEleve', data);
 }

 getAll():Observable<Formation[]>{
  return this.http.get<Formation[]>(this.connect.apiuri+'auth/GetFormations');
}
update(data: Formation) {
  return this.http.post(this.baseUrl +'/auth/ModifyActivity' + data.Id, data);
}



 delete(Id:any) {
   return this.http.delete(this.baseUrl +'auth/deletee/' + Id);
 }
 findFormationById(Id:any)
 {
  return this.http.get(this.connect.apiuri+'auth/get/' + Id);
 }
}

