package it.akademija.paujak.sandelys.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import it.akademija.paujak.sandelys.enums.KlientoTipas;

@Entity
@Table(name = "klientai")
public class Klientas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String vardas;
	private String pavarde;
	private LocalDate gimimoData;
	private String telNumeris;
	private KlientoTipas tipas;

}
