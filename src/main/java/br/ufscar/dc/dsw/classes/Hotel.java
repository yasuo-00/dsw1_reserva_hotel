package br.ufscar.dc.dsw.classes;

public class Hotel {
	private String cnpj;
	private String name;
	private String city;
	private double dailyRate;
	private String phone;
	
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
	
	
}
