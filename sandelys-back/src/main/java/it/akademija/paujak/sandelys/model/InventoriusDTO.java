package it.akademija.paujak.sandelys.model;

import java.time.LocalDate;

public class InventoriusDTO {
	private Long id;
	private String pavadinimas;
	private double svoris;
	private int sektorius;
	private LocalDate talpinimoData;
	private KlientasDTO klientas;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPavadinimas() {
		return pavadinimas;
	}
	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}
	public double getSvoris() {
		return svoris;
	}
	public void setSvoris(double svoris) {
		this.svoris = svoris;
	}
	public int getSektorius() {
		return sektorius;
	}
	public void setSektorius(int sektorius) {
		this.sektorius = sektorius;
	}
	public LocalDate getTalpinimoData() {
		return talpinimoData;
	}
	public void setTalpinimoData(LocalDate talpinimoData) {
		this.talpinimoData = talpinimoData;
	}
	public KlientasDTO getKlientas() {
		return klientas;
	}
	public void setKlientas(KlientasDTO klientas) {
		this.klientas = klientas;
	}
	
	
	
}
