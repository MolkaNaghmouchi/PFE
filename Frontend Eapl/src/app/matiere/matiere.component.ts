import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ConnectpointService } from '../services/connectpoint.service';
import { FormationsService } from '../services/formations.service';

import { MatiereService } from '../services/matiere.service';

@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrls: ['./matiere.component.scss']
})
export class MatiereComponent implements OnInit {
  formation:any;
  showComment=false;
  idFormation
  constructor( public endpoint:ConnectpointService , private router:Router , private  _formation : FormationsService) { }

  ngOnInit(): void {
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

delete(idFormation:any){
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
  this._formation.delete(idFormation).subscribe(
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
