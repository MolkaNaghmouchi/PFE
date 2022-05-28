import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UtilisateurservService } from 'src/app/services/utilisateurserv.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-ajoutenseignant',
  templateUrl: './ajoutenseignant.component.html',
  styleUrls: ['./ajoutenseignant.component.scss']
})
export class AjoutenseignantComponent implements OnInit {

  imageCIn:any;
  constructor(private _utilisateur:UtilisateurservService,private router:Router,)  { }
  user={
 id:'',
firstName:'',
lastName:'',
userName:'',
email:'',
 password:'',
starterDate:'',
age:'',
	 active:'',
   adresse:'',
   genre:'',
   num:'',
   nump:'',
   niveau:'',
   role:'',

  }








  ngOnInit(): void {

  }

  addEnseignant(){
    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'ajout avec succees',
      showConfirmButton: false,
      timer: 1500
    })


   this._utilisateur.addEnseignant(this.user).subscribe(
      (res)=>{










    console.log(res);
    console.log(this.user.firstName);
    this.router.navigate(['/Enseignant'])
      },
      err=>{
        console.log(err);

      }
    )

  }

  uploadImageCin(imageCIn){
    let reader = new FileReader();
    if(imageCIn.files.length!==0) {
      reader.readAsDataURL(imageCIn.files[0]);
      reader.onload = e => {
        this.imageCIn = reader.result;

      }
    }
  }


}
function role(arg0: (res: Object) => void, arg1: any, role: any, arg3: string, arg4: void) {
  throw new Error('Function not implemented.');
}

