package br.ufscar.dc.dsw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.classes.BookingSite;
import br.ufscar.dc.dsw.classes.Hotel;
import br.ufscar.dc.dsw.classes.SaleOff;
import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.dao.IBookingSiteDAO;
import br.ufscar.dc.dsw.dao.IHotelDAO;
import br.ufscar.dc.dsw.dao.ISaleOffDAO;
import br.ufscar.dc.dsw.dao.IUserDAO;

@SpringBootApplication
public class SpringMVCApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringMVCApplication.class);

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(SpringMVCApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BCryptPasswordEncoder encoder,IUserDAO dao, IHotelDAO hDao, IBookingSiteDAO bDao, ISaleOffDAO sDao) {
		return (args) -> {

			User u1 = new User("admin", encoder.encode("admin"));
			dao.save(u1);

			Hotel h1 = new Hotel("13423525", "okomo", "1243131", "ABV", 100.5, "hotel", encoder.encode("hotel"));
			Hotel h2 = new Hotel("75675675", "shfdg", "1243342", "ABV", 99, "h2", encoder.encode("h2"));
			hDao.save(h1);
			hDao.save(h2);

			BookingSite b1 = new BookingSite("url", "aosn", "234523523", "b1", encoder.encode("b1"));
			bDao.save(b1);
			
			SaleOff s1 = new SaleOff(h1, b1, 14);
			sDao.save(s1);
			
			Iterable<Hotel> result = hDao.findAll();
			for (Hotel h : result) {
				System.out.println(h.getCnpj());
			}
		};
	}
}
