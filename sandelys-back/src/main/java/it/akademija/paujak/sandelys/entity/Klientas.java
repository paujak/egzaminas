package it.akademija.paujak.sandelys.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.akademija.paujak.sandelys.enums.KlientoTipas;

@SuppressWarnings("serial")
@Entity
@Table(name = "klientai",
uniqueConstraints = { @UniqueConstraint(columnNames = { "vardas", "pavarde", "gimimoData" }) })
public class Klientas implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String vardas;
	@NotNull
	private String pavarde;
	@NotNull
	private LocalDate gimimoData;
	@NotNull
	private String telNumeris;
	@NotNull
	private KlientoTipas tipas;
	@OneToMany(mappedBy = "klientas", cascade = CascadeType.ALL)
	private List<Inventorius> inventoriausSarasas;
	
	public Klientas() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVardas() {
		return vardas;
	}
	public void setVardas(String vardas) {
		this.vardas = vardas;
	}
	public String getPavarde() {
		return pavarde;
	}
	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}
	public LocalDate getGimimoData() {
		return gimimoData;
	}
	public void setGimimoData(LocalDate gimimoData) {
		this.gimimoData = gimimoData;
	}
	public String getTelNumeris() {
		return telNumeris;
	}
	public void setTelNumeris(String telNumeris) {
		this.telNumeris = telNumeris;
	}
	public KlientoTipas getTipas() {
		return tipas;
	}
	public void setTipas(KlientoTipas tipas) {
		this.tipas = tipas;
	}
	public List<Inventorius> getInventoriausSarasas() {
		return inventoriausSarasas;
	}
	public void setInventoriausSarasas(List<Inventorius> inventoriausSarasas) {
		this.inventoriausSarasas = inventoriausSarasas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gimimoData == null) ? 0 : gimimoData.hashCode());
		result = prime * result + ((pavarde == null) ? 0 : pavarde.hashCode());
		result = prime * result + ((vardas == null) ? 0 : vardas.hashCode());
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
		Klientas other = (Klientas) obj;
		if (gimimoData == null) {
			if (other.gimimoData != null) {
				return false;
			}
		} else if (!gimimoData.equals(other.gimimoData)) {
			return false;
		}
		if (pavarde == null) {
			if (other.pavarde != null) {
				return false;
			}
		} else if (!pavarde.equals(other.pavarde)) {
			return false;
		}
		if (vardas == null) {
			if (other.vardas != null) {
				return false;
			}
		} else if (!vardas.equals(other.vardas)) {
			return false;
		}
		return true;
	}

	
	
}
