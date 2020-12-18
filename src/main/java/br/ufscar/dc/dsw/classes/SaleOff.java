package br.ufscar.dc.dsw.classes;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "sale_off")
public class SaleOff {

	@EmbeddedId
	private SaleOffId saleOffId;

	@ManyToOne
	@MapsId("hotelId")
	@JoinColumn(name = "hotel_id")
	Hotel hotel;

	@ManyToOne
	@MapsId("bookingSiteId")
	@JoinColumn(name = "booking_site_id")
	BookingSite bookingSite;


	private double discount;

	public SaleOff() {
		super();
	}

	public SaleOff(SaleOffId saleOffId, Hotel hotel, BookingSite bookingSite,  double discount) {
		this.saleOffId = saleOffId;
		this.hotel = hotel;
		this.bookingSite = bookingSite;
		this.discount = discount;
	}

	public SaleOffId getSaleOffId() {
		return saleOffId;
	}

	public void setSaleOffId(SaleOffId saleOffId) {
		this.saleOffId = saleOffId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public BookingSite getBookingSite() {
		return bookingSite;
	}

	public void setBookingSite(BookingSite bookingSite) {
		this.bookingSite = bookingSite;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingSite, discount, hotel, saleOffId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleOff other = (SaleOff) obj;
		return Objects.equals(bookingSite, other.bookingSite)
				&& Double.doubleToLongBits(discount) == Double.doubleToLongBits(other.discount)
				&& Objects.equals(hotel, other.hotel) && Objects.equals(saleOffId, other.saleOffId);
	}

	/*
	 * public LocalDate getInitialDate() { return initialDate; }
	 * 
	 * public void setInitialDate(LocalDate initialDate) { this.initialDate =
	 * initialDate; }
	 * 
	 * public LocalDate getFinalDate() { return finalDate; }
	 * 
	 * public void setFinalDate(LocalDate finalDate) { this.finalDate = finalDate; }
	 */

	/*
	 * @Override public int hashCode() { return Objects.hash(bookingSite, discount,
	 * finalDate, hotel, initialDate, saleOffId); }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; SaleOff other = (SaleOff) obj; return Objects.equals(bookingSite,
	 * other.bookingSite) && Double.doubleToLongBits(discount) ==
	 * Double.doubleToLongBits(other.discount) && Objects.equals(finalDate,
	 * other.finalDate) && Objects.equals(hotel, other.hotel) &&
	 * Objects.equals(initialDate, other.initialDate) && Objects.equals(saleOffId,
	 * other.saleOffId); }
	 */
	
	

}
