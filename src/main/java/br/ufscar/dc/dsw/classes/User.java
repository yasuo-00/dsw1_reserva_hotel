package br.ufscar.dc.dsw.classes;

public class User {
	int id;
	String email;
	String password;
	String hotelCnpj;
	String bookingSiteUrl;
	
	
	public User() {
	}
	
	public User(int id) {
		this.id = id;
	}
	

	public User(int id, String email, String password, String hotelCnpj, String bookingSiteUrl) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.hotelCnpj = hotelCnpj;
		this.bookingSiteUrl = bookingSiteUrl;
	}
	
	public User(String email, String password, String hotelCnpj, String bookingSiteUrl) {
		this.email = email;
		this.password = password;
		this.hotelCnpj = hotelCnpj;
		this.bookingSiteUrl = bookingSiteUrl;
	}
	
	public int getId() {
		return id;
	}
	public String getHotelCnpj() {
		return hotelCnpj;
	}
	public void setHotelCnpj(String hotelCnpj) {
		this.hotelCnpj = hotelCnpj;
	}
	public String getBookingSiteUrl() {
		return bookingSiteUrl;
	}
	public void setBookingSiteUrl(String bookingSiteUrl) {
		this.bookingSiteUrl = bookingSiteUrl;
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
	
}
