import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PaiementService } from 'src/app/services/paiement.service';

@Component({
  selector: 'app-updatepayement',
  templateUrl: './updatepayement.component.html',
  styleUrls: ['./updatepayement.component.scss']
})
export class UpdatepayementComponent implements OnInit {

  response: any;
  id:any;

  constructor(private route:ActivatedRoute ,private _matiere: PaiementService, private router: Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get('id');
  

    this._matiere.getById(this.id).subscribe(
     (res)=>{
      this.response=res,
      this.paiement=this.response},
      (err)=>{
        console.log(err);

      }
    )
  }
  paiement={
    id:'',
    date_paiement:'',
    Montant:'',
    Nom_Matiere:'',
    users:'',
    Mois:'',
   
  

  }
     update(){
       console.log(this.paiement.id);
       
   

     this._matiere.update(this.id,this.paiement).subscribe(
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

