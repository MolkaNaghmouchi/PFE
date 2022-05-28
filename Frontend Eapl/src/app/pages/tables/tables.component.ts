import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PaiementService } from 'src/app/services/paiement.service';
import { UtilisateurservService } from 'src/app/services/utilisateurserv.service';
import { PaiementDtoResponse } from 'src/app/Types/Paiement';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.scss']
})
export class TablesComponent implements OnInit {

  paiement:any;
  user:any;

  savedPaiement:any;

  constructor(private _paiement:PaiementService, _utilisateur:UtilisateurservService,private router:Router) { }

  ngOnInit(): void {
    this._paiement.getAll().subscribe(
      (res)=>{
        this.paiement=res;
        console.log(res);

      },
      (err)=>{
        console.log(err);

      }
    )
  }


  createEleveName(paiements:PaiementDtoResponse[]){
    let eleveName = "";

    if(paiements !== null && paiements !== undefined) {
      paiements.forEach(element => {
        eleveName += element.eleveName;
        eleveName += ", "
      });
    }

    return  eleveName
  }



  delete(id:any){
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
    this._paiement.delete(id).subscribe(
      res=>{
        console.log(res);
        this.ngOnInit();

      },
      err=>{
      console.log(err);

      }
    )
    swalWithBootstrapButtons.fire(
      'Deleted!',
      'Your file has been deleted.',
      'success'
    )
  } else if (
    /* Read more about handling dismissals below */
    result.dismiss === Swal.DismissReason.cancel
  ) {
    swalWithBootstrapButtons.fire(
      'Cancelled',
      'Your imaginary file is safe :)',
      'error'
    )
  }
  })

  }
    }
