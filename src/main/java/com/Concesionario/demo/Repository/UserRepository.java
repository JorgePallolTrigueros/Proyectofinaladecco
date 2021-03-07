package com.Concesionario.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Concesionario.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	// Filtrar por email y password
	Optional<User> findByEmailAndPassword(String email, String password);

	
	//List<Shopcart> findAllByUsersId(Long id);
}
