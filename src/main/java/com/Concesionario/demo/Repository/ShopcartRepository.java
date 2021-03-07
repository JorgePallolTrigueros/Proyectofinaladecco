package com.Concesionario.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Concesionario.demo.entities.Shopcart;

@Repository
public interface ShopcartRepository extends JpaRepository<Shopcart, Long>{

	List<Shopcart> findAllByUserId(Long id);

}
