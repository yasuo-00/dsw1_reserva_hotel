package br.ufscar.dc.dsw.classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SaleOffId implements Serializable {
	
	@Column(name= "hotel_cnpj")
	private String hotelCnpj;
	
	@Column(name = "booking_site_url")
	private String bookingSiteUrl;
	
	@Column(name = "initial_date")
	private LocalDate initialDate;
	
	@Column(name = "final_date")
	private LocalDate finalDate;

	 public SaleOffId() {
		super();
	}

	public SaleOffId(String hotelCnpj, String bookingSiteUrl, LocalDate initialDate, LocalDate finalDate) {
		super();
		this.hotelCnpj = hotelCnpj;
		this.bookingSiteUrl = bookingSiteUrl;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
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

	public LocalDate getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}

	public LocalDate getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingSiteUrl, finalDate, hotelCnpj, initialDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleOffId other = (SaleOffId) obj;
		return Objects.equals(bookingSiteUrl, other.bookingSiteUrl) && Objects.equals(finalDate, other.finalDate)
				&& Objects.equals(hotelCnpj, other.hotelCnpj) && Objects.equals(initialDate, other.initialDate);
	}


	
	


}
