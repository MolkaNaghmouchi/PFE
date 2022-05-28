import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormationService } from 'src/app/services/formation.service';
import { MatiereService } from 'src/app/services/matiere.service';

@Component({
  selector: 'app-addmatiere',
  templateUrl: './addmatiere.component.html',
  styleUrls: ['./addmatiere.component.scss']
})
export class AddmatiereComponent implements OnInit {
  constructor(public _formation: FormationService ,private router:Router,)  { }

formation={
  Id:'',
    intituleFormation:'',
    description:'',
    typeFormation:'',
    prix:0,

    mode:'',
   debut:''



  }





  ngOnInit(): void {

  }

  ajout(){
    console.log(this.formation);




    this._formation.ajout(this.formation).subscribe(
      (res)=>{


    console.log(res);
    this.router.navigate(['/matiere'])
      },
      err=>{
        console.log(err);

      }
    )

  }
}
