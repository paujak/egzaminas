package it.akademija.paujak.sandelys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.akademija.paujak.sandelys.entity.Inventorius;

public interface InventoriusRepository extends JpaRepository<Inventorius, Long> {

	@Query("SELECT inv FROM Inventorius inv "
			+ "LEFT OUTER JOIN Klientas kl "
			+ "ON inv.klientas = kl.id WHERE kl.id = :id")
	List<Inventorius> getAllByCustomerId(@Param("id") Long id);
	

}
