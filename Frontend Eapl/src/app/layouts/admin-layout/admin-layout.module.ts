import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ClipboardModule } from 'ngx-clipboard';

import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent } from '../../pages/dashboard/dashboard.component';

import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { TablesComponent } from '../../pages/tables/tables.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FullCalendarModule } from '@fullcalendar/angular';
import { AuthInterceptor } from 'src/app/auth/AuthInterceptor.interceptor';
import { ListeleveComponent } from 'src/app/eleves/listeleve/listeleve.component';
import { ConfirmationService } from 'primeng/api';
import { ElevesService } from 'src/app/services/eleves.service';
import { AuthService } from 'src/app/auth/Auth.service';
import { AdminLayoutComponent } from './admin-layout.component';
import { FormationService } from 'src/app/services/formation.service';

// import { ToastrModule } from 'ngx-toastr';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    HttpClientModule,
    NgbModule,
    ClipboardModule,
    FullCalendarModule,
    ConfirmDialogModule,
  ],
  declarations: [
    DashboardComponent,
    UserProfileComponent,
    TablesComponent,

  ],


providers: [
 
    AuthService,ConfirmationService,UserProfileComponent,FormationService
],
bootstrap: [AdminLayoutComponent]
})
export class AdminLayoutModule {}
function appRoutes(appRoutes: any): any[] | import("@angular/core").Type<any> | import("@angular/core").ModuleWithProviders<{}> {
  throw new Error('Function not implemented.');
}