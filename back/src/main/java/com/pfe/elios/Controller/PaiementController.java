package com.pfe.elios.Controller;


import com.pfe.elios.entities.Paiement;
import com.pfe.elios.entities.PaiementDto;
import com.pfe.elios.entities.PaiementDtoResponse;
import com.pfe.elios.entities.User;

import com.pfe.elios.services.PaiementService;
import com.pfe.elios.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Lazy
@Transactional
@RestController
@RequestMapping("auth/paiement")
public class PaiementController {
    @Autowired
    private final PaiementService paiementService;
    @Autowired
    private final UserService userService;
    public PaiementController(PaiementService paiementService, UserService userService) {
        this.paiementService = paiementService;
        this.userService = userService;
    }
   @PostMapping("/add")
    public ResponseEntity<Paiement> addPaiement(@RequestBody PaiementDto paiementDto) {
       User user =  userService.findUserById(paiementDto.getId());

        var newPaiement =new Paiement();
        newPaiement.setMontant(paiementDto.getMontant());
        newPaiement.setDate_paiement(paiementDto.getDate_paiement());
        newPaiement.setEtatDePayment(paiementDto.getEtatDePayment());
        newPaiement.setMois(paiementDto.getMois());


        newPaiement.setUser(user);

       var crs  = user.getPaiement();


        Paiement peristedPaiement = paiementService.addPaiement(newPaiement);
       user.setPaiement(newPaiement);
       ResponseEntity<?> u =userService.addUser1(user);
        return new ResponseEntity<>(peristedPaiement, HttpStatus.CREATED);
    }





  @GetMapping("/all")
    public ResponseEntity<List<PaiementDtoResponse>> getAllPaiements () {
        List<PaiementDtoResponse> paiements = paiementService.findAllPaiements();
        return new ResponseEntity<>(paiements , HttpStatus.OK);
    }

    @GetMapping("/find/{idPay}")
    public ResponseEntity<Paiement> getPaiementById (@PathVariable("idPay") Long idPay) {
        Paiement paiement = paiementService.findPaiementByIdPay(idPay);
        return new ResponseEntity<>(paiement, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Paiement> updatPaiement(@RequestBody Paiement paiement) {
        Paiement updatePaiement =paiementService.updatePaiement(paiement);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idPay}")
    public ResponseEntity<?> deletePaiement(@PathVariable("idPay") Long idPay) {
        paiementService.deletePaiement(idPay);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/patch")
    public ResponseEntity<Paiement> patchPaiement(@RequestBody Paiement paiement) {
        Paiement updatePaiement =paiementService.updatePaiement(paiement);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
