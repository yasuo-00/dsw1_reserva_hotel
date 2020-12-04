package br.ufscar.dc.dsw.classes;

import java.time.LocalDate;

public class SaleOff {
	String hotelCnpj;
	String bookingSiteUrl;
	LocalDate initialDate;
	LocalDate finalDate;
	double discount;
	
	
	
	public SaleOff(String hotelCnpj, String bookingSiteUrl, LocalDate initialDate, LocalDate finalDate, double discount) {
		super();
		this.hotelCnpj = hotelCnpj;
		this.bookingSiteUrl = bookingSiteUrl;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.discount = discount;
	}
	
	public SaleOff(String hotelCnpj, String bookingSiteUrl, LocalDate initialDate, LocalDate finalDate) {
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
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
}
