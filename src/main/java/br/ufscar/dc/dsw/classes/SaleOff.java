package br.ufscar.dc.dsw.classes;

import java.util.Date;

public class SaleOff {
	String hotelCNPJ;
	String bookingSiteURL;
	Date initialDate;
	Date finalDate;
	double discount;
	
	
	
	public SaleOff(String hotelCNPJ, String bookingSiteURL, Date initialDate, Date finalDate, double discount) {
		super();
		this.hotelCNPJ = hotelCNPJ;
		this.bookingSiteURL = bookingSiteURL;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.discount = discount;
	}
	
	public SaleOff(String hotelCNPJ, String bookingSiteURL, Date initialDate, Date finalDate) {
		super();
		this.hotelCNPJ = hotelCNPJ;
		this.bookingSiteURL = bookingSiteURL;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}



	public String getHotelCNPJ() {
		return hotelCNPJ;
	}
	public void setHotelCNPJ(String hotelCNPJ) {
		this.hotelCNPJ = hotelCNPJ;
	}
	public String getBookingSiteURL() {
		return bookingSiteURL;
	}
	public void setBookingSiteURL(String bookingSiteURL) {
		this.bookingSiteURL = bookingSiteURL;
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
