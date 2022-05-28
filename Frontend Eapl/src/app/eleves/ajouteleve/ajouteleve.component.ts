import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UtilisateurservService } from 'src/app/services/utilisateurserv.service';

@Component({
  selector: 'app-ajouteleve',
  templateUrl: './ajouteleve.component.html',
  styleUrls: ['./ajouteleve.component.scss']
})
export class AjouteleveComponent implements OnInit {
  imageCIn:any
  selectedFile: any;
  constructor(private _utilisateur: UtilisateurservService, private router: Router) { }
  user={
    id:'',
   firstName:'',
   lastName:'',
   email:'',
    password:'',
    userName:'',
   starterDate:'',
   age:0,
      active:'',
      adresse:'',
      niveau:'',
      genre:'',
      num:'',
      nump:'',
      PhotoBytes:''
     }








     ngOnInit(): void {

     }

     addEleves(){
       console.log(this.user);




       this._utilisateur.addEleves(this.user).subscribe(
         (res)=>{


       console.log(res);
       console.log(this.user.firstName);
       this.router.navigate(['/eleves'])
         },
         err=>{
           console.log(err);

         }
       )

     }



     onFileChanged(event: any) {
      this.selectedFile = event.target.files[0];
      console.log(this.selectedFile);
      const reader = new FileReader();
      reader.readAsDataURL(this.selectedFile);

    }

uploadImageCin(imageCIn){
  let reader = new FileReader();
  if(imageCIn.files.length!==0) {
    reader.readAsDataURL(imageCIn.files[0]);
    reader.onload = e => {
      this.imageCIn = reader.result;
      this.user.PhotoBytes=btoa(this.imageCIn);
    }
  }
}
  }



