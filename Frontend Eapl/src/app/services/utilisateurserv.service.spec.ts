import { TestBed } from '@angular/core/testing';

import { UtilisateurservService } from './utilisateurserv.service';

describe('UtilisateurservService', () => {
  let service: UtilisateurservService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UtilisateurservService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
