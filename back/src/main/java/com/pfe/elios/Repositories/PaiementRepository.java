package com.pfe.elios.Repositories;

import com.pfe.elios.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement,Long> {

  void deletePaiementByIdPay(Long idPay);
    Paiement findPaiementByIdPay(Long idPay);


}
