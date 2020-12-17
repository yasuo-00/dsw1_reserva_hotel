package br.ufscar.dc.dsw.classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SaleOffId implements Serializable {
	
	@Column(name= "hotel_id")
	private Long hotelId;
	
	@Column(name = "booking_site_id")
	private Long bookingSiteId;
	
	@Column(name = "initial_date")
	private LocalDate initialDate;
	
	@Column(name = "final_date")
	private LocalDate finalDate;

	 public SaleOffId() {
		super();
	}

	public SaleOffId(Long hotelId,Long bookingSiteId, LocalDate initialDate, LocalDate finalDate) {
		super();
		this.hotelId = hotelId;
		this.bookingSiteId = bookingSiteId;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}

	
	
	public Long getHotelCnpj() {
		return hotelId;
	}

	public void setHotelCnpj(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getBookingSiteUrl() {
		return bookingSiteId;
	}

	public void setBookingSiteUrl(Long bookingSiteId) {
		this.bookingSiteId = bookingSiteId;
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
		return Objects.hash(bookingSiteId, finalDate, hotelId, initialDate);
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
		return Objects.equals(bookingSiteId, other.bookingSiteId) && Objects.equals(finalDate, other.finalDate)
				&& Objects.equals(hotelId, other.hotelId) && Objects.equals(initialDate, other.initialDate);
	}


	
	


}
