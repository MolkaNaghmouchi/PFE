import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormationService } from 'src/app/services/formation.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listformation',
  templateUrl: './listformation.component.html',
  styleUrls: ['./listformation.component.scss']
})
export class ListformationComponent implements OnInit {
  formation:any;



  constructor(public _formation: FormationService,private router:Router,) { }

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
    this._formation.delete(id).subscribe(
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
