import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatiereService } from 'src/app/services/matiere.service';

@Component({
  selector: 'app-detailsformation',
  templateUrl: './detailsformation.component.html',
  styleUrls: ['./detailsformation.component.scss']
})
export class DetailsformationComponent implements OnInit {

 matiere:any;
  id:any;


  constructor(private _matiere:MatiereService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this._matiere.getById(this.id).subscribe(
      (res)=>{
        this.matiere=res;
        console.log(res);

      },
      (err)=>{
        console.log(err);

      }
    )
    }
  }
