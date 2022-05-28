import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UtilisateurservService } from 'src/app/services/utilisateurserv.service';

@Component({
  selector: 'app-updateenseignant',
  templateUrl: './updateenseignant.component.html',
  styleUrls: ['./updateenseignant.component.scss']
})
export class UpdateenseignantComponent implements OnInit {

  id:any;
  response:any;
  constructor(private route:ActivatedRoute ,private _utilisateur: UtilisateurservService, private router: Router) { }
 image:any


  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get('id');
  

    this._utilisateur.getById(this.id).subscribe(
     (res)=>{
      this.response=res,
      this.user=this.response},
      (err)=>{
        console.log(err);

      }
    )
  }
  user={
    id: '',
    firstName: '',
    lastName: '',
    email: '',
    password: '',
    starterDate: '',
    age: 0,
    active: '',
    adresse:'',
    genre:'',
    num:'',

     }
     update(){
       console.log(this.user.firstName);
       
   

     this._utilisateur.update(this.id,this.user).subscribe(
      (res)=>{
    console.log(res);
    this.router.navigate(['/dashboard/listenseignant'])
      },
      err=>{
        console.log(err);

      }
    )

    }
}

