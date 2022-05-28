import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormationService } from 'src/app/services/formation.service';
import { GroupeService } from 'src/app/services/groupe.service';

@Component({
  selector: 'app-ajoutgroupe',
  templateUrl: './ajoutgroupe.component.html',
  styleUrls: ['./ajoutgroupe.component.scss']
})
export class AjoutgroupeComponent implements OnInit {
  formation:any;

  constructor(public _groupe: GroupeService ,private router:Router,private _formation:FormationService)  { }

  groupe={
    id:'',
    nom_groupe:'',
    niveau:'',

    idFormation:'',




  }




  ngOnInit(): void {
    this.getformation();

  }


  getformation(){
    this._formation.getAll().subscribe(
      (res)=>{
        this.formation =res;
        console.log(res);

      },
      (err)=>{
        console.log(err);


      }
    )
  }

  ajout(){





    this._groupe.ajout(this.groupe).subscribe(
      (res)=>{


    console.log(res);
    this.router.navigate(['/groupe'])
      },
      err=>{
        console.log(err);

      }
    )

  }
}

