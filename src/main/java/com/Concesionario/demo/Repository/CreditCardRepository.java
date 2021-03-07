package com.Concesionario.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Concesionario.demo.entities.CreditCard;

public interface CreditCardRepository extends JpaRepository <CreditCard, String>{


}