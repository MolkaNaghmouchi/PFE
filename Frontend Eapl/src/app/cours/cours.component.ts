import { Formation } from 'src/app/pages/Model/formation';
import { FormationService } from './../services/formation.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { cour } from '../pages/Model/cour';
import { CoursService } from '../services/cours.service';

@Component({
  selector: 'app-cours',
  templateUrl: './cours.component.html',
  styleUrls: ['./cours.component.scss']
})
export class CoursComponent implements OnInit {


  cour:any;
  id:any;
  formation:any

  savedCour:any;



  constructor(public _cour: CoursService,private router:Router,private _formation:FormationService ) { }

  ngOnInit(): void {
    this.getall();
    //this.savedCour=this._cour.savedCours

  }
  ajout(){
 console.log(this.cour[0].idFormation);
  }
  getformateurbyid(id:any){
    this._formation.getById(this.id).subscribe(
      (res)=>{
      console.log(res);
    this.formation=res;}


    )

  }




  createFormationsName(formations){
    let formationsName = "";

    if(formations !== null && formations !== undefined) {
      formations.forEach(element => {
        formationsName += element.intituleFormation;
        formationsName += ", "
      });
    }

    return formationsName
  }


  getall(){
    this._cour.getAll().subscribe(
      (res)=>{
        this.cour=res;
        console.log("----->", res);
        this._formation.getById(this.cour[0].idFormation);
        console.log(this.cour[0].idFormation)
        console.log(this.formation)



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
    this._cour.delete(id).subscribe(
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
