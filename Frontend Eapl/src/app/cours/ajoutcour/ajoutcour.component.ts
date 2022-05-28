import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { cour } from 'src/app/pages/Model/cour';
import { Formation } from 'src/app/pages/Model/formation';
import { CoursService } from 'src/app/services/cours.service';

import { FileUploadService } from 'src/app/services/file-upload.service';
import { FormationsService } from 'src/app/services/formations.service';

@Component({
  selector: 'app-ajoutcour',
  templateUrl: './ajoutcour.component.html',
  styleUrls: ['./ajoutcour.component.scss']
})
export class AjoutcourComponent implements OnInit {
formation: any;



constructor(private _formation:FormationsService,public _cour:CoursService , private router:Router,){}

  cour={

    nom_cour:'',
    niveau:'',

    idFormation:''







  }




  ngOnInit(): void {
    //this.fileInfos = this.uploadService.getFiles();
    this.getformation()

  }
  getformation(){
    this._formation.getAll().subscribe(
      (res)=>{
        this.formation =res;
        console.log(res);

      },
      (err)=>{
        console.log(err);


      }
    )
  }

  ajout(){
    console.log('yu')



    console.log("+++++",this.cour.idFormation)
    console.log("----->",this.cour)

    this._cour.ajout(this.cour).subscribe(


      (res)=>{

        console.log('2')
        this._cour.savedCours = res;

    console.log(res);

    this.router.navigate(['/cours']);

      },
      err=>{
        console.log(err);

      }
    )

  }
 /* selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }
  upload(): void {
    this.progress = 0;
    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);
      if (file) {
        this.currentFile = file;
        this.uploadService.upload(this.currentFile).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progress = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              this.message = event.body.message;
              this.fileInfos = this.uploadService.getFiles();
            }
          },
          (err: any) => {
            console.log(err);
            this.progress = 0;
            if (err.error && err.error.message) {
              this.message = err.error.message;
            } else {
              this.message = 'Could not upload the file!';
            }
            this.currentFile = undefined;
          });
      }
      this.selectedFiles = undefined;
    }
  }*/
}



