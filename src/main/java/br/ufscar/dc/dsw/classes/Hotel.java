package br.ufscar.dc.dsw.classes;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel extends User{
	
	@Column(nullable = false, unique = true, length = 14)
	private String cnpj;
	
	@Column(nullable = false, unique = false, length = 60)
	private String name;
	
	@Column(nullable = false, unique = false, length = 60)
	private String city;
	
	@Column(nullable = false, unique = false, length = 60)
	private double dailyRate;
	
	@Column(nullable = false, unique = false, length = 13)
	private String phone;
	
	@OneToMany(mappedBy = "hotel")
	private List<SaleOff> saleOffs;
	
	public Hotel() {
		this.cnpj="cnpj";
		this.name = "name";
		this.phone = "phone";
		this.city = "city";
		this.dailyRate = 0;
	}
	
	public Hotel (String cnpj, String name, String phone, String city, double dailyRate) {
		this.cnpj=cnpj;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.dailyRate = dailyRate;
	}
	
	
	public Hotel(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(city, cnpj, dailyRate, name, phone, saleOffs);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		return Objects.equals(city, other.city) && Objects.equals(cnpj, other.cnpj)
				&& Double.doubleToLongBits(dailyRate) == Double.doubleToLongBits(other.dailyRate)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(saleOffs, other.saleOffs);
	}
	
	
}
