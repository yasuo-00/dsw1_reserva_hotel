
package br.ufscar.dc.dsw;

import java.time.LocalDate;

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.classes.SaleOffId;
import br.ufscar.dc.dsw.dao.BookingSiteDAO;
import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.dao.SaleOffDAO;
import br.ufscar.dc.dsw.dao.UserDAO;



public class Populate {
	public static void main(String[] args) {
		
		UserDAO userDao = new UserDAO();
		HotelDAO hotelDao = new HotelDAO();
		BookingSiteDAO bookingSiteDao = new BookingSiteDAO();
		SaleOffDAO saleOffDao = new SaleOffDAO();
		
		Hotel hotel = new Hotel("123", "hotel1", "333333", "São Carlos", 150, "hotel1", "hotel1");
		hotelDao.save(hotel);
		
		BookingSite bookingSite = new BookingSite("url.com", "site1", "323232323", "site1", "site1");
		bookingSiteDao.save(bookingSite);
		
		LocalDate initialDate =  LocalDate.parse("2020-01-01");
		LocalDate finalDate = LocalDate.parse("2020-02-02");
		SaleOffId saleOffId = new SaleOffId(hotel.getId(), bookingSite.getId(), initialDate, finalDate);
		SaleOff saleOff = new SaleOff(saleOffId, hotel, bookingSite, 10);
		
		saleOffDao.save(saleOff);
		
		
	}
}
