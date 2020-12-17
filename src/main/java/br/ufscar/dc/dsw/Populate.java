
package br.ufscar.dc.dsw;

import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.dao.BookingSiteDAO;
import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.dao.UserDAO;



public class Populate {
	public static void main(String[] args) {
		
		UserDAO userDao = new UserDAO();
		HotelDAO hotelDao = new HotelDAO();
		BookingSiteDAO bookingSiteDao = new BookingSiteDAO();
		
		Hotel hotel = new Hotel("123", "hotel1", "333333", "São Carlos", 150, "hotel1", "hotel1");
	}
}
