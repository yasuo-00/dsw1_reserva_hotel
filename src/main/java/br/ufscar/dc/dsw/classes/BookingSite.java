package br.ufscar.dc.dsw.classes;

public class BookingSite {
	
	private String url;
	private String name;
	private String phone;
	
	public BookingSite(String url, String name, String phone) {
		this.url = url;
		this.name = name;
		this.phone = phone;
		
	}
	
	public BookingSite(String url) {
		this.url = url;
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
