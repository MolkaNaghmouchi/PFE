import { CoursComponent } from './../../cours/cours.component';
import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';

import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { TablesComponent } from '../../pages/tables/tables.component';
import { ListeleveComponent } from 'src/app/eleves/listeleve/listeleve.component';
import { ListenseignantComponent } from 'src/app/Enseignant/listenseignant/listenseignant.component';
import { AjouteleveComponent } from 'src/app/eleves/ajouteleve/ajouteleve.component';
import { AjoutenseignantComponent } from 'src/app/Enseignant/ajoutenseignant/ajoutenseignant.component';
import { UpdateenseignantComponent } from 'src/app/Enseignant/updateenseignant/updateenseignant.component';
import { UpdateeleveComponent } from 'src/app/eleves/updateeleve/updateeleve.component';
import { CalenderComponent } from 'src/app/calender/calender.component';
import { AddpayementComponent } from 'src/app/pages/tables/addpayement/addpayement.component';

import { MatiereComponent } from 'src/app/matiere/matiere.component';
import { AddmatiereComponent } from 'src/app/matiere/addmatiere/addmatiere.component';
import { PaiementComponent } from 'src/app/pages/maps/paiement.component';


import { DetailsformationComponent } from 'src/app/matiere/detailsformation/detailsformation.component';
import { AjoutseanceComponent } from 'src/app/calender/ajoutseance/ajoutseance.component';
import { QuizFormComponent } from 'src/app/QuizWork/quiz-form/quiz-form.component';
import { PassquizComponent } from 'src/app/QuizWork/passquiz/passquiz.component';
import { QuizComponent } from 'src/app/QuizWork/quiz/quiz.component';
import { FileUploadComponent } from 'src/app/pages/file-upload/file-upload.component';
import { CharteComponent } from 'src/app/charte/charte.component';
import { AjoutgroupeComponent } from 'src/app/pages/groupe/ajoutgroupe/ajoutgroupe.component';
import { GroupeComponent } from 'src/app/pages/groupe/groupe.component';
import { AjoutcourComponent } from 'src/app/cours/ajoutcour/ajoutcour.component';
import { ListformationComponent } from 'src/app/matiere/listformation/listformation.component';
import { Listenseignanttomponent } from 'src/app/eleves/listeleve copy/listeleve.component';
import { ListformattionComponent } from 'src/app/eleves/listeleve copy 2/listeleve.component';
import { HomeComponent } from 'src/app/home/home.component';





export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent },
    { path: 'tables',         component: TablesComponent },
    { path: 'eleves',         component:ListeleveComponent },
    { path: 'ajouteleve',          component: ListformattionComponent  },
    { path: 'updateeleve',         component:UpdateeleveComponent },
    { path: 'Enseignant',   component:ListenseignantComponent },
    {path: 'ajoutEnseignant', component:AjoutenseignantComponent},
    {path: 'updateEnseignant/:id', component:UpdateenseignantComponent},
   {path: 'calender', component:CalenderComponent},
   {path:'ajoutpaiement', component:AddpayementComponent},
   {path: 'Matiere', component:MatiereComponent},
   {path: 'ajoutmatiere', component:AddmatiereComponent},
  {path:'paiement', component:PaiementComponent},

  {path:'ajoutseance', component:AjoutseanceComponent},
  {path:'Detailsformation', component:DetailsformationComponent},
  {path:'quiz', component:QuizFormComponent},
  {path:'passequiz', component:PassquizComponent},
  {path:'file', component:FileUploadComponent},
  {path:'quizhome', component:QuizComponent},
  {path:'charte', component:CharteComponent},
  {path:'ajoutgroupe', component:AjoutgroupeComponent},
  {path:'groupe', component:GroupeComponent},
  {path:'ajoutcour', component:AjoutcourComponent},
  {path:'cours', component: CoursComponent},
  {path:'listformation', component: ListformationComponent},
  {path:'gestion enseignant', component: Listenseignanttomponent},
 



];
