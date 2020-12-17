package br.ufscar.dc.dsw.classes;

import java.util.Objects;

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
	Long id;
	
	@Column(nullable = false, unique = true, length = 60)
	String email;
	
	@Column(nullable = false, unique = false, length = 60)	
	String password;
	
	public User() {
	}
	
	public User(Long id) {
		this.id = id;
	}
	

	public User(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;

	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public Long getId() {
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

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(password, other.password);
	}
	
	
	
}
