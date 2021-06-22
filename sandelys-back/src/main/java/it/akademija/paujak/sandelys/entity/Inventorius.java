package it.akademija.paujak.sandelys.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

@SuppressWarnings("serial")
@Entity
@Table(name = "inventorius")
public class Inventorius implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Inventoriaus pavadinimas būtinas")
	private String pavadinimas;
	@NotNull(message = "Būtina nurodyti inventoriaus svorį")
	private double svoris;
	@NotNull(message = "Būtina nurodyti inventoriaus sektorių (1-40)")
	@Min(value = 1, message= "Negali būti mažesnis už 1")
	@Max(value = 40, message = "Negali būti didesnis už 40")
	private int sektorius;
	private LocalDate talpinimoData;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "klientas_id")
	private Klientas klientas;
	
	public Klientas getKlientas() {
		return klientas;
	}
	public void setKlientas(Klientas klientas) {
		this.klientas = klientas;
	}
	public Inventorius() {
		super();
	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((klientas == null) ? 0 : klientas.hashCode());
		result = prime * result + ((pavadinimas == null) ? 0 : pavadinimas.hashCode());
		result = prime * result + sektorius;
		long temp;
		temp = Double.doubleToLongBits(svoris);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((talpinimoData == null) ? 0 : talpinimoData.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Inventorius other = (Inventorius) obj;
		if (klientas == null) {
			if (other.klientas != null) {
				return false;
			}
		} else if (!klientas.equals(other.klientas)) {
			return false;
		}
		if (pavadinimas == null) {
			if (other.pavadinimas != null) {
				return false;
			}
		} else if (!pavadinimas.equals(other.pavadinimas)) {
			return false;
		}
		if (sektorius != other.sektorius) {
			return false;
		}
		if (Double.doubleToLongBits(svoris) != Double.doubleToLongBits(other.svoris)) {
			return false;
		}
		if (talpinimoData == null) {
			if (other.talpinimoData != null) {
				return false;
			}
		} else if (!talpinimoData.equals(other.talpinimoData)) {
			return false;
		}
		return true;
	}
	
	
}
