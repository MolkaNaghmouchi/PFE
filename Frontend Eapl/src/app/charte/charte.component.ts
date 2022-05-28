import { Component, OnInit } from '@angular/core';
import { FormationService } from '../services/formation.service';
import { MatiereService } from '../services/matiere.service';
import { UtilisateurservService } from '../services/utilisateurserv.service';

@Component({
  selector: 'app-charte',
  templateUrl: './charte.component.html',
  styleUrls: ['./charte.component.scss']
})
export class CharteComponent implements OnInit {

  constructor(private _utilisateur:UtilisateurservService,private _matiere:FormationService) {} 
user:any;
  ngOnInit(): void {
    this.getelev()
  
  }
getelev(){  this._utilisateur.getelev().subscribe(
  (res)=>{
    this.user=res;
    this.user.forEach(element => {
      element.PhotoBytes =atob(element.PhotoBytes);
    });
    console.log(res);

  },
  (err)=>{
    console.log(err);

  }
)
}
}
