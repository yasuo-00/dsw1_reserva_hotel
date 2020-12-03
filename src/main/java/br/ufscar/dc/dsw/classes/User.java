package br.ufscar.dc.dsw.classes;

public class User {
	int id;
	String email;
	String password;
	String hotelCNPJ;
	String bookingSiteURL;
	
	
	public User() {
	}
	
	public User(int id) {
		this.id = id;
	}
	

	public User(int id, String email, String password, String hotelCNPJ, String bookingSiteURL) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.hotelCNPJ = hotelCNPJ;
		this.bookingSiteURL = bookingSiteURL;
	}
	
	public User(String email, String password, String hotelCNPJ, String bookingSiteURL) {
		this.email = email;
		this.password = password;
		this.hotelCNPJ = hotelCNPJ;
		this.bookingSiteURL = bookingSiteURL;
	}
	
	public int getId() {
		return id;
	}
	public String getHotelCNPJ() {
		return hotelCNPJ;
	}
	public void setHotelCNPJ(String hotelCNPJ) {
		this.hotelCNPJ = hotelCNPJ;
	}
	public String getBookingSiteURL() {
		return bookingSiteURL;
	}
	public void setBookingSiteURL(String bookingSiteURL) {
		this.bookingSiteURL = bookingSiteURL;
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
