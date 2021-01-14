package br.ufscar.dc.dsw.classes;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "booking_site")
@DynamicUpdate
public class BookingSite extends User{
	
	@Column(nullable = false, unique = true, length = 60)
	private String url;
	
	@Column(nullable = false, unique = false, length = 60)
	private String name;
	
	@Column(nullable = false, unique = false, length = 13)
	private String phone;
	
	@OneToMany(mappedBy = "bookingSite")
	@Cascade(CascadeType.ALL)
	private List<SaleOff> saleOffs;
	
	public BookingSite() {
	}
	
	public BookingSite(String url, String name, String phone, String email, String password) {
		super(email, password, "ROLE_BOOKINGSITE");
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

	@Override
	public int hashCode() {
		return Objects.hash(name, phone, saleOffs, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingSite other = (BookingSite) obj;
		return Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(saleOffs, other.saleOffs) && Objects.equals(url, other.url);
	}
	
	
	

}
