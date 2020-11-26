package br.ufscar.dc.dsw.classes;

public class Hotel {
	private String email;
	private String password;
	private String cnpj;
	private String name;
	private String city;
	private double dailyRate;
	private String phone;
	
	public Hotel (String cnpj, String name, String phone, String city, String email, String password, double dailyRate) {
		this.cnpj=cnpj;
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.email = email;
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCNPJ() {
		return cnpj;
	}
	public void setCNPJ(String cnpj) {
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
