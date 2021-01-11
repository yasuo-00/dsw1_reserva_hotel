package br.ufscar.dc.dsw.classes;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "sale_off", 
       uniqueConstraints={
	    @UniqueConstraint(columnNames = {"hotel_id", "site_id", 
	    		                         "initial_date",
	    		                         "final_date"})})
public class SaleOff {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	@Cascade(CascadeType.REMOVE)
	Hotel hotel;

	@ManyToOne
	@JoinColumn(name = "site_id")
	@Cascade(CascadeType.REMOVE)
	BookingSite bookingSite;

	@Column(name = "initial_date")
	private LocalDate initialDate;
	
	@Column(name = "final_date")
	private LocalDate finalDate;
	
	@Column(name = "discount", columnDefinition = "DECIMAL")
	private double discount;

	public SaleOff() {
		super();
	}

	public SaleOff(Hotel hotel, BookingSite bookingSite,  double discount) {
		this.hotel = hotel;
		this.bookingSite = bookingSite;
		finalDate = LocalDate.parse("2020-01-01");
		initialDate = LocalDate.parse("2020-01-01");
		this.discount = discount;
	}
	
	public SaleOff(Hotel hotel, BookingSite bookingSite,  double discount, LocalDate initialDate, LocalDate finalDate) {
		this.hotel = hotel;
		this.bookingSite = bookingSite;
		this.finalDate = finalDate; 
		this.initialDate = initialDate;
		this.discount = discount;
	}

	
	
	public Long getId() {
		return id;
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
		return Objects.hash(bookingSite, discount, hotel);
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
				&& Objects.equals(hotel, other.hotel);
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
