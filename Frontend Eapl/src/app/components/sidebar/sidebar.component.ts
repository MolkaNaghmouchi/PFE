import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare interface RouteInfo {
    path: string;
    title: string;

    icon: string;
    class: string;
}
const newLocal = 'ajouteleve';
export const ROUTES: RouteInfo[] = [

  { path: '/dashboard', title: 'dashboard',   icon: 'ni-tv-2 text-red', class: '' },
    { path: '/eleves', title: 'Eleves', icon: 'ni-hat-3 text-brown', class: '' },

    { path: '/gestion enseignant', title: 'Enseignant',  icon:'ni-circle-08 text-blue', class: '' },
    { path: '/user-profile', title: 'profile ',  icon:'ni-single-02 text-yellow', class: '' },
    { path: '/Matiere', title: 'catalogue formation', icon:'ni-book-bookmark  text-brown', class: '' },
    { path: '/ajouteleve', title: 'formation', icon:'ni-bullet-list-67 text-pink', class: '' },
    { path: '/cours', title: ' Cour', icon:'ni-bullet-list-67 text-red', class: '' },
    { path: '/file', title: 'deposez cour', icon:'ni-bullet-list-67 text-blue', class: '' },
    { path: '/formations', title: 'Gestion Cour', icon:'ni-bullet-list-67 text-blud', class: '' },
    { path: '/passequiz', title: 'passe quiz', icon:'ni-bullet-list-67 text-red', class: '' },
    { path: '/quiz', title: 'gestion quiz', icon:'ni-bullet-list-67 text-red', class: '' },
    { path: '/calender', title: 'Seance', icon:'ni-calendar-grid-58', class: '' },
    { path: '/tables', title: 'Paiement', icon:'ni-bullet-list-67 text-pink', class: '' },

    { path: '/groupe', title: 'Groupe', icon:'ni-bullet-list-67 text-pink', class: '' },

    { path: '/login', title: 'Login',   icon:'ni-key-25 text-info', class: '' },
    { path: '/register', title: 'Register', icon:'ni-circle-08 text-green', class: '' }

];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  public menuItems: any[];
  public isCollapsed = true;

  constructor(private router: Router) { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
    this.router.events.subscribe((event) => {
      this.isCollapsed = true;
   });
  }
}
