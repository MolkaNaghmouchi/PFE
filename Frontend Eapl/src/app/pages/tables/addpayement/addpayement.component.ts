import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PaiementService } from 'src/app/services/paiement.service';
import { UtilisateurservService } from 'src/app/services/utilisateurserv.service';
import Swal from 'sweetalert2';



export interface PaimentDto {


   date_paiement:Date,
   Mois:string,
   etatDePayment:string,
   id:number,
   Montant?:string
}
@Component({
  selector: 'app-addpayement',
  templateUrl: './addpayement.component.html',
  styleUrls: ['./addpayement.component.scss']
})
export class AddpayementComponent implements OnInit {

  constructor(private _utilisateur:UtilisateurservService,public _paiement: PaiementService ,private router:Router,)  { }

    paiement:PaimentDto={

date_paiement:null,
      Mois:'1',
      etatDePayment:'',
      id:0,
      Montant:"12"


    }
    user:any;



    ngOnInit(): void {
this._utilisateur.getelev().subscribe((res)=>{
  this.user = res
  console.log(res)})
    }


    ajout(){
      console.log(this.paiement);




      this._paiement.ajout(this.paiement).subscribe(
        (res)=>{


      console.log(res);
      this.router.navigate(['/paiement'])
        },
        err=>{
          console.log(err);

        }
      )

    }
  }
