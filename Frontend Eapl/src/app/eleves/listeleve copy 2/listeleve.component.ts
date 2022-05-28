import { Component, OnInit,Input, Injectable } from '@angular/core';


import { Observable } from 'rxjs';


import { ConfirmationService } from 'primeng/api';

import { ElevesService } from 'src/app/services/eleves.service';
import { user } from 'src/app/pages/Model/user';
import { ToastrService } from 'ngx-toastr';
import { Formation } from 'src/app/pages/Model/formation';
import { FormationsService } from 'src/app/services/formations.service';
@Component({
  selector: 'app-listeleve',
  templateUrl: './listeleve.component.html',
  styleUrls: ['./listeleve.component.scss']
})

export class ListformattionComponent implements OnInit {
  users: Observable<Formation[]>;
  data: Formation[];
  current_formation: Formation = new Formation();
  crud_operation = {is_new: true, is_visible: true};
  confirm = true;


  showModal: boolean;
  cols = [
    { field: 'action', header: 'Action', class:'ui-p-1' },
    { field: 'Image', header: 'Action', class:'ui-p-1' },
    { field: 'IntituleFormation', header: 'nom de formation', class:'ui-p-2' },
    { field: ' TypeFormation', header: 'typeFormation', class:'ui-p-2' },
    {field: ' Prix', header: ' prix' , class:'ui-p-3'},
    { field: 'Mode', header: 'mode', class: 'ui-p-4' },
    {field: 'Duree', header: 'duree', class: 'ui-p-4' },
    {field: 'Description', header: 'description', class: 'ui-p-4' },

  ];
  loading: boolean= false;


  constructor(private service: FormationsService, private toastr: ToastrService,
    private confirmationService: ConfirmationService) {
    this.data = [];
  }

  ngOnInit(): void {
    this.read();
  }

  read() {
    this.service.read().subscribe((res: any) => {
      this.data = res;
      this.current_formation = new Formation();
    });
  }




  new() {
    this.current_formation = new Formation();
    this.crud_operation.is_visible = true;
    this.crud_operation.is_new = true;
  }

  save() {
    console.log(this.current_formation);
    if (this.crud_operation.is_new) {

      this.service.insert(this.current_formation).subscribe(res => {
        if (res === true) {
          this.showModal = false;
          this.current_formation = new Formation();
          this.crud_operation.is_visible = false;
          this.read();
          this.toastr.success('Formateur bien ajouté !');
        } else {
          this.toastr.error('Erreur !');
        }
      });
      return;
    }
    this.service.update(this.current_formation).subscribe(res => {
      this.current_formation = new Formation();
      this.crud_operation.is_visible = false;
      this.read();
      this.toastr.warning('Eleve modifié avec succès!');
    });
  }

  edit(row) {
    this.crud_operation.is_visible = true;
    this.crud_operation.is_new = false;
    this.current_formation = row;

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
