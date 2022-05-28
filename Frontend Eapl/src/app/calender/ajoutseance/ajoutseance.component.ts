import { Router } from '@angular/router';
import { SeanceService } from './../../services/seance.service';
import { Component, OnInit } from '@angular/core';
import { FormationsService } from 'src/app/services/formations.service';

@Component({
  selector: 'app-ajoutseance',
  templateUrl: './ajoutseance.component.html',
  styleUrls: ['./ajoutseance.component.scss']
})
export class AjoutseanceComponent implements OnInit {

  formation: any;

  constructor(public _seance: SeanceService,private _formation:FormationsService ,private router:Router,)  { }

    seance={
      id:'',
      titre:'',
      date_debut:'',

      date_fin:'',
      idFormation:'',




    }




    ngOnInit(): void {
      this.getformation()
    }

    getformation(){
      this._formation.getAll().subscribe(
        (res)=>{
          this.formation=res;
          console.log(res);

        },
        (err)=>{
          console.log(err);


        }
      )
    }
    ajout(){





      this._seance.ajout(this.seance).subscribe(
        (res)=>{

          console.log('2')
          this._seance.savedSeances = res;
      console.log(res);

      this.router.navigate(['/calender'])
        },
        err=>{
          console.log(err);

        }
      )

    }
  }
