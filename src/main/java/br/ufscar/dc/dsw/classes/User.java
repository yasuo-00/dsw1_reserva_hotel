package br.ufscar.dc.dsw.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(nullable = false, unique = true, length = 60)
	String email;
	
	@Column(nullable = false, unique = true, length = 60)	
	String password;
	
	public User() {
	}
	
	public User(int id) {
		this.id = id;
	}
	

	public User(int id, String email, String password, String hotelCnpj, String bookingSiteUrl) {
		this.id = id;
		this.email = email;
		this.password = password;

	}
	
	public User(String email, String password, String hotelCnpj, String bookingSiteUrl) {
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
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
