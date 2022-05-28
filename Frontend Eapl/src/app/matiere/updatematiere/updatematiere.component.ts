import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatiereService } from 'src/app/services/matiere.service';


@Component({
  selector: 'app-updatematiere',
  templateUrl: './updatematiere.component.html',
  styleUrls: ['./updatematiere.component.scss']
})
export class UpdatematiereComponent implements OnInit {
  response: any;
  id:any;

  constructor(private route:ActivatedRoute ,private _matiere: MatiereService, private router: Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get('id');
  

    this._matiere.getById(this.id).subscribe(
     (res)=>{
      this.response=res,
      this.matiere=this.response},
      (err)=>{
        console.log(err);

      }
    )
  }
  matiere={
    id:'',
    nom_mat:'',
    niveau:'',
    classe:'',
   
  

  }
     update(){
       console.log(this.matiere.nom_mat);
       
   

     this._matiere.update(this.id,this.matiere).subscribe(
      (res)=>{
    console.log(res);
    this.router.navigate(['/dashboard/matiere'])
      },
      err=>{
        console.log(err);

      }
    )

    }
}

