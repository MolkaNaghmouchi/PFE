



  import {Component, OnInit} from '@angular/core';
  import {FormBuilder, FormGroup, Validators} from '@angular/forms';
  
  import {ToastrService} from 'ngx-toastr';
  import { map } from 'rxjs/operators'; 
  import {ConfirmationService} from 'primeng/api';
  import {DatePipe} from '@angular/common';
import { EnseignantService } from 'src/app/services/enseignant.service';

import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { FormationService } from 'src/app/services/formation.service';
import { Formation } from '../Model/formation';
import { ListenseignantComponent } from 'src/app/Enseignant/listenseignant/listenseignant.component';
  
  
  
  
  
  @Component({
    selector: 'app-user-profile',
    templateUrl: './user-profile.component.html',
    styleUrls: ['./user-profile.component.scss']
  })
  export class UserProfileComponent implements OnInit  {
    
  
    ngOnInit(): void {
    
    }
  
   
  }