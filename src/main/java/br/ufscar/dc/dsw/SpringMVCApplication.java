package br.ufscar.dc.dsw;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

			Hotel h1 = new Hotel("13423525", "Hotel São Carlos", "1243131", "São Carlos", 100.5, "h1", encoder.encode("h1"));
			Hotel h2 = new Hotel("75675675", "Hotel Brasil", "1243342", "São Carlos", 99, "h2", encoder.encode("h2"));
			Hotel h3 = new Hotel("45346334", "Hotel Império", "4112213", "São Paulo",130, "h3", encoder.encode("h3"));
			Hotel h4 = new Hotel("675373373", "Hotel Rio", "74645645", "Rio de Janeiro",150, "h4", encoder.encode("h4"));
			hDao.save(h1);
			hDao.save(h2);
			hDao.save(h3);
			hDao.save(h4);

			BookingSite b1 = new BookingSite("reserveaqui.com", "Reserve Aqui", "234523523", "b1", encoder.encode("b1"));
			BookingSite b2 = new BookingSite("promocoesdehotel.com.br", "Promoções de Hotel", "1231312", "b2",encoder.encode("b2"));
			BookingSite b3 = new BookingSite("buscapromocoes.com.br", "Busca de Promoções", "9879789789", "b3",encoder.encode("b3"));
			bDao.save(b1);
			bDao.save(b2);
			bDao.save(b3);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			SaleOff s1 = new SaleOff(h1, b1, 10, LocalDate.parse("2020-01-01", formatter), LocalDate.parse("2020-02-01", formatter));
			SaleOff s2 = new SaleOff(h1, b2, 5, LocalDate.parse("2020-10-10", formatter), LocalDate.parse("2020-10-15", formatter));
			SaleOff s3 = new SaleOff(h2, b1, 15, LocalDate.parse("2021-01-01", formatter), LocalDate.parse("2021-02-01", formatter));
			SaleOff s4 = new SaleOff(h3, b2, 7, LocalDate.parse("2020-06-23", formatter), LocalDate.parse("2020-07-19", formatter));
			SaleOff s5 = new SaleOff(h3, b1, 5, LocalDate.parse("2020-01-01", formatter), LocalDate.parse("2020-02-01", formatter));
			sDao.save(s1);
			sDao.save(s2);
			sDao.save(s3);
			sDao.save(s4);
			sDao.save(s5);
			
			Iterable<Hotel> result = hDao.findAll();
			for (Hotel h : result) {
				System.out.println(h.getCnpj());
			}
		};
	}
}
