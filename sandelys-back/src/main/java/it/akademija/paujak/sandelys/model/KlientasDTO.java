package it.akademija.paujak.sandelys.model;

import java.time.LocalDate;

import it.akademija.paujak.sandelys.enums.KlientoTipas;

public class KlientasDTO {

	private Long id;
	private String vardas;
	private String pavarde;
	private LocalDate gimimoData;
	private String telNumeris;
	private KlientoTipas tipas;
	
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
		KlientasDTO other = (KlientasDTO) obj;
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
