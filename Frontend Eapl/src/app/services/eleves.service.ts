import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { user } from '../pages/Model/user';


@Injectable({
  providedIn: 'root'
})
export class ElevesService {

  data: user[];
  baseUrl = environment.URL;
  constructor(public http: HttpClient) { }
  read(): Observable<any>{
    return this.http.get(this.baseUrl+'auth/alleleves');
  }

 insert(data: user) {
   return this.http.post(this.baseUrl +'auth/addEleve', data);
 }

 update(data: user) {
   return this.http.post(this.baseUrl +'auth/updateById/' + data.id, data);
 }
 
 delete(id) {
   return this.http.delete(this.baseUrl +'auth/delete/' + id);
 }

}

