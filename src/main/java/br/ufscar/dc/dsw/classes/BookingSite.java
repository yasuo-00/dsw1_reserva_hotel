package br.ufscar.dc.dsw.classes;

public class BookingSite {
	
	private String email;
	private String password;
	private String url;
	private String name;
	private String phone;
	
	public BookingSite(String url, String name, String phone, String password, String email) {
		this.url = url;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.email = email;
		
	}
	
	public BookingSite(String url) {
		this.url = url;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
