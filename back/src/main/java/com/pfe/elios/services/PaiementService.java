package com.pfe.elios.services;

import com.pfe.elios.Repositories.PaiementRepository;
import com.pfe.elios.entities.Paiement;
import com.pfe.elios.entities.PaiementDtoResponse;
import com.pfe.elios.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Lazy
@Service
@Transactional
public class PaiementService {
    @Autowired
    private final PaiementRepository paiementRepository;
    @Autowired
    private final FormationService formationService;

    @Autowired
    private final UserService userService;

    public PaiementService(PaiementRepository paiementRepository, FormationService formationService, UserService userService) {
        this.paiementRepository = paiementRepository;
        this.formationService = formationService;
        this.userService = userService;
    }

    public Paiement addPaiement(Paiement paiement) {

        return paiementRepository.save(paiement);
    }


  public List<PaiementDtoResponse> findAllPaiements() {

        var crx = paiementRepository.findAll().stream().map(paiement -> {
            var dtoResponse = new PaiementDtoResponse();
            User user = userService.findUserById(paiement.getUser().getId());
            dtoResponse.setDate_paiement(paiement.getDate_paiement());
            dtoResponse.setMontant(paiement.getMontant());
            dtoResponse.setMois(paiement.getMois());
            dtoResponse.setId(paiement.getIdPay());
            dtoResponse.setEleveName(user.getFirstName());
            return dtoResponse;
        }).collect(Collectors.toList());

        return crx;
    }


    public Paiement updatePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public Paiement findPaiementByIdPay(Long idPay) {
        return paiementRepository.findPaiementByIdPay(idPay);

    }

    public void deletePaiement(Long idPay) {
        paiementRepository.deletePaiementByIdPay(idPay);
    }


  /*  public Paiement patchPaiement(Paiement paiement) {

        Paiement paiement=paiementRepository.findPaiementByIdPay(paiement);
        paiement.setEtatDePayment(paiement.getEtatDePayment());
        return paiement;
    }*/

}

