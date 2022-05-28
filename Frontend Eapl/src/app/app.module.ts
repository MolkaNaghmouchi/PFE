import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app.routing';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppComponent } from './app.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { RouterModule, Routes } from '@angular/router';
import { ComponentsModule } from './components/components.module';
import { ListeleveComponent } from './eleves/listeleve/listeleve.component';
import { AjouteleveComponent } from './eleves/ajouteleve/ajouteleve.component';
import { ListenseignantComponent } from './Enseignant/listenseignant/listenseignant.component';
import { AjoutenseignantComponent } from './Enseignant/ajoutenseignant/ajoutenseignant.component';
import { UpdateenseignantComponent } from './Enseignant/updateenseignant/updateenseignant.component';
import { CalenderComponent } from './calender/calender.component';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import { AddpayementComponent } from './pages/tables/addpayement/addpayement.component';
import { GroupeComponent } from './pages/groupe/groupe.component';
import { MatiereComponent } from './matiere/matiere.component';
import { AddmatiereComponent } from './matiere/addmatiere/addmatiere.component';
import { UpdatematiereComponent } from './matiere/updatematiere/updatematiere.component';
import {FullCalendarModule } from '@fullcalendar/angular'; // must go before plugins
import dayGridPlugin from '@fullcalendar/daygrid'; // a plugin!
import interactionPlugin from '@fullcalendar/interaction';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from './auth/Auth.service';
import { AuthInterceptor } from './auth/AuthInterceptor.interceptor';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule}from '@angular/material/dialog';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

// @ts-ignore
import {MatButtonModule, MatCardModule, MatCheckboxModule, MatDatepickerModule, MatFormFieldModule, MatNativeDateModule, MatTooltipModule} from '@angular/material';
import { BrowserModule } from '@angular/platform-browser';
import { ConfirmationService, SharedModule } from 'primeng/api';
import { UpdateeleveComponent } from './eleves/updateeleve/updateeleve.component';
import { FileUploadComponent } from './pages/file-upload/file-upload.component';


import { ButtonModule } from 'primeng/button';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ToastrModule,
  ToastNoAnimation,

  ToastNoAnimationModule
} from 'ngx-toastr';

import {TableModule} from 'primeng/table';
import {TooltipModule} from "primeng/tooltip";
import {  MatRippleModule } from '@angular/material/core';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSliderModule } from '@angular/material/slider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { MatTreeModule } from '@angular/material/tree';
import { DialogModule } from "primeng/dialog";
import {MatStepperModule} from "@angular/material/stepper";
import {GalleriaModule} from "primeng/galleria";
import {RadioButtonModule} from "primeng/radiobutton";
import { ElevesService } from './services/eleves.service';
import { EnseignantService } from './services/enseignant.service';

import { UserProfileComponent } from './pages/user-profile/user-profile.component';
import { FormationService } from './services/formation.service';
import { CoursComponent } from './cours/cours.component';
import { AjoutcourComponent } from './cours/ajoutcour/ajoutcour.component';
import { DetailsformationComponent } from './matiere/detailsformation/detailsformation.component';
import { AjoutseanceComponent } from './calender/ajoutseance/ajoutseance.component';
import { QuizComponent } from './QuizWork/quiz/quiz.component';
import { QuizFormComponent } from './QuizWork/quiz-form/quiz-form.component';
import { PassquizComponent } from './QuizWork/passquiz/passquiz.component';
import { NotifierModule } from 'angular-notifier';
import { AjoutgroupeComponent } from './pages/groupe/ajoutgroupe/ajoutgroupe.component';
import { ListformationComponent } from './matiere/listformation/listformation.component';
import { Listenseignanttomponent } from './eleves/listeleve copy/listeleve.component';
import { ListformattionComponent } from './eleves/listeleve copy 2/listeleve.component';
import { HomeComponent } from './home/home.component';
import { CompComponent } from './comp/comp.component';
const MATERIAL_MODULES = [MatToolbarModule,
  MatIconModule
];

FullCalendarModule.registerPlugins([ // register FullCalendar plugins
  dayGridPlugin,
  interactionPlugin
]);


@NgModule({
  imports: [

    BrowserModule,
    FormsModule ,
    ToastrModule.forRoot(),
    ComponentsModule,
    ToastNoAnimationModule,
    MatTableModule,
    TooltipModule,
    RouterModule,
    MatTreeModule,
    MatRippleModule,
    MatTabsModule,
    MatRadioModule,
    MatSlideToggleModule,
    AppRoutingModule,
    MatSliderModule,
    MatStepperModule,
    RadioButtonModule,
    GalleriaModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatSnackBarModule,
    MatSidenavModule,
    ConfirmDialogModule,
    ButtonModule,
    ToastrModule.forRoot(),
    BrowserModule,
    MatDialogModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatIconModule,
    MatSelectModule,
    DialogModule,
    FormsModule,
    NgbModule,
    TableModule,
    MatPaginatorModule,
    FullCalendarModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatProgressBarModule,
    NotifierModule,
    HttpClientModule,


  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    AuthLayoutComponent,
    ListeleveComponent,
    AjouteleveComponent,
     ListenseignantComponent,
     AjoutenseignantComponent,
     UpdateeleveComponent,
     UpdateenseignantComponent,
     CalenderComponent,
     AddpayementComponent,
     GroupeComponent,
     MatiereComponent,
     AddmatiereComponent,
     UpdatematiereComponent,

     FileUploadComponent,
     CoursComponent,
     AjoutcourComponent,
     DetailsformationComponent,
     AjoutseanceComponent,
    QuizComponent,
    QuizFormComponent,
    PassquizComponent,
    AjoutgroupeComponent,
    ListformationComponent ,
    Listenseignanttomponent ,
    ListformattionComponent,
    HomeComponent,
    CompComponent ,
    ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
      AuthService,ConfirmationService,ElevesService,ListeleveComponent,UserProfileComponent,FormationService,ListenseignantComponent,EnseignantService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
function appRoutes(appRoutes: any): any[] | import("@angular/core").Type<any> | import("@angular/core").ModuleWithProviders<{}> {
  throw new Error('Function not implemented.');
}

