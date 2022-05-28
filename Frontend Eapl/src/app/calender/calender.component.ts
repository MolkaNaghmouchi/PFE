import { Component, OnInit } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/angular';
import { SeanceService } from '../services/seance.service';

@Component({
  selector: 'app-calender',
  templateUrl: './calender.component.html',
  styleUrls: ['./calender.component.scss']
})
export class CalenderComponent implements OnInit {
  Events: any[] = [];
  calendarOptions: CalendarOptions = {
    headerToolbar: {
      left: 'prev,next today',
      center: 'title',
      right: 'dayGridMonth'
    },
    initialView: 'dayGridMonth',
    weekends: true,
    editable: true,
    selectable: true,
    selectMirror: true,
    dayMaxEvents: true,
  };



  savedSeance:any;

  emploi: any
  constructor(private _emploi:SeanceService) { }

  ngOnInit(): void {
    this._emploi.getAll().subscribe(
      (res)=>{
        console.log(res)
        this.emploi=res;
        for(let e of this.emploi){
          this.Events.push( {  title: e.titre, start: e.date_debut, end: e.date_fin , display: 'color'  } )
        }
        this.calendarOptions.events = this.Events;
      },
      (err)=>{
        console.log(err);

      }
    )
    }
    createFormationsName(formations){
      let formationsName = "";
  
      if(formations !== null && formations !== undefined) {
        formations.forEach(element => {
          formationsName += element.intituleFormation;
          formationsName += ", "
        });
      }
  
      return formationsName
    }

}
