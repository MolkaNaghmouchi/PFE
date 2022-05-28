import { Component, OnInit,Input, Injectable } from '@angular/core';


import { Observable } from 'rxjs';


import { ConfirmationService } from 'primeng/api';

import { ElevesService } from 'src/app/services/eleves.service';
import { user } from 'src/app/pages/Model/user';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-listeleve',
  templateUrl: './listeleve.component.html',
  styleUrls: ['./listeleve.component.scss']
})

export class ListeleveComponent implements OnInit {
  users: Observable<user[]>;
  data: user[];
  current_user: user = new user();
  crud_operation = {is_new: true, is_visible: true};
  confirm = true;


  showModal: boolean;
  cols = [
    { field: 'action', header: 'Action', class:'ui-p-1' },
    { field: 'userName', header: 'Nomutilisateur', class:'ui-p-2' },
    { field: 'lastName', header: 'Nom', class:'ui-p-2' },
    {field: 'firstName', header: 'Prénom' , class:'ui-p-3'},
    { field: 'StarterDate', header: 'Date naissance', class: 'ui-p-4' },
    // { field: 'cin', header: 'CIN' , class: 'ui-p-5'},
    { field: 'email', header: 'E-mail' , class: 'ui-p-7'},
    { field: 'adresse', header: 'Adresse' , class: 'ui-p-6'}
  ];
  loading: boolean= false;


  constructor(private service: ElevesService, private toastr: ToastrService,
    private confirmationService: ConfirmationService) {
    this.data = [];
  }

  ngOnInit(): void {
    this.read();
  }

  read() {
    this.service.read().subscribe((res: any) => {
      this.data = res;
      this.current_user = new user();
    });
  }




  new() {
    this.current_user = new user();
    this.crud_operation.is_visible = true;
    this.crud_operation.is_new = true;
  }

  save() {
    console.log(this.current_user);
    if (this.crud_operation.is_new) {

      this.service.insert(this.current_user).subscribe(res => {
        if (res === true) {
          this.showModal = false;
          this.current_user = new user();
          this.crud_operation.is_visible = false;
          this.read();
          this.toastr.success('Formateur bien ajouté !');
        } else {
          this.toastr.error('Erreur !');
        }
      });
      return;
    }
    this.service.update(this.current_user).subscribe(res => {
      this.current_user = new user();
      this.crud_operation.is_visible = false;
      this.read();
      this.toastr.warning('Eleve modifié avec succès!');
    });
  }

  edit(row) {
    this.crud_operation.is_visible = true;
    this.crud_operation.is_new = false;
    this.current_user = row;

  }

  delete(id) {
    this.service.delete(id).subscribe(res => {
      this.crud_operation.is_new = false;
      this.read();
      this.toastr.info('Eleve supprimé  avec succès!');
    });
  }
  confirmEdit(data) {
    this.confirmationService.confirm({
      message: 'Voulez-vous modifier?',
      header: 'Modfier Eleve',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.edit(data);
        this.showModal=true;

      },
      reject: () => {
      }
    });
  }
  confirmDelete(data) {
    this.confirmationService.confirm({
      message: 'Voulez-vous supprimmer?',
      header: 'Supprimmer Formateur',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.delete(data.id)
      },
      reject: () => {
      }
    });
  }
}
