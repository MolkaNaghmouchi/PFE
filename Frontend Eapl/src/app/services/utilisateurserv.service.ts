import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConnectpointService } from './connectpoint.service';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurservService {

  
  constructor(private http : HttpClient, private connect:ConnectpointService) { }
  ajout(user:any){
    return this.http.post(this.connect.apiuri +'auth/addUser', user);
 }

 getAll(){
  return this.http.get(this.connect.apiuri+'auth/all');
}
getelev(){
  return this.http.get(this.connect.apiuri+'auth/alleleves');
}

getensg(){
  return this.http.get(this.connect.apiuri+'auth/allenseig');
}

addEleves(Eleve:any){
  return this.http.post(this.connect.apiuri+'auth/addEleve',Eleve);
}
addEnseignant(Enseignant:any){
  return this.http.post(this.connect.apiuri+'auth/addEnseignant',Enseignant);
}

delete(id:any){
  return this.http.delete(this.connect.apiuri+'auth/delete/'+id)
}
deletelev(id:any){
  return this.http.delete(this.connect.apiuri+'utilisateur/'+id)
}
update(id:any,user:any){
  return this.http.put(this.connect.apiuri+'utilisateur/update/'+ id,user);
}
getById(id:any){
  return this.http.get(this.connect.apiuri+'utilisateur/'+id);
}
Register(user:any){
  return this.http.post(this.connect.apiuri+'auth/Register',user);
}



 }






