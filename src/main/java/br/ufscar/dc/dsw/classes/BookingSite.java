package br.ufscar.dc.dsw.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "booking_site")
public class BookingSite {
	
	@Column(nullable = false, unique = true, length = 60)
	private String url;
	
	@Column(nullable = false, unique = false, length = 60)
	private String name;
	
	@Column(nullable = false, unique = false, length = 13)
	private String phone;
	
	public BookingSite() {
		this.url = "url";
		this.name = "name";
		this.phone = "phone";
	}
	
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
