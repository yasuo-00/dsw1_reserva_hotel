package br.ufscar.dc.dsw.classes;

import java.util.Date;

public class SaleOff {
	String hotelCnpj;
	String bookingSiteUrl;
	Date initialDate;
	Date finalDate;
	double discount;
	
	
	
	public SaleOff(String hotelCnpj, String bookingSiteUrl, Date initialDate, Date finalDate, double discount) {
		super();
		this.hotelCnpj = hotelCnpj;
		this.bookingSiteUrl = bookingSiteUrl;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.discount = discount;
	}
	
	public SaleOff(String hotelCnpj, String bookingSiteUrl, Date initialDate, Date finalDate) {
		super();
		this.hotelCnpj = hotelCnpj;
		this.bookingSiteUrl = bookingSiteUrl;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}



	public String getHotelCNPJ() {
		return hotelCnpj;
	}
	public void setHotelCNPJ(String hotelCnpj) {
		this.hotelCnpj = hotelCnpj;
	}
	public String getBookingSiteURL() {
		return bookingSiteUrl;
	}
	public void setBookingSiteURL(String bookingSiteUrl) {
		this.bookingSiteUrl = bookingSiteUrl;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
}
