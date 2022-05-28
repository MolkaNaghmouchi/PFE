import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ConfirmationService } from 'primeng/api';

import { GroupeService } from 'src/app/services/groupe.service';
import { UtilisateurservService } from 'src/app/services/utilisateurserv.service';
import { environment } from 'src/environments/environment';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-groupe',
  templateUrl: './groupe.component.html',
  styleUrls: ['./groupe.component.scss']
})
export class GroupeComponent implements OnInit {



  groupe:any;
  user:any;


  constructor(private _groupe:GroupeService, _utilisateur:UtilisateurservService,private router:Router) { }

  ngOnInit(): void {
    this._groupe.getAll().subscribe(
      (res)=>{
        this.groupe=res;
        console.log(res);

      },
      (err)=>{
        console.log(err);

      }
    )
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
    this._groupe.delete(id).subscribe(
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

