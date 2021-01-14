package br.ufscar.dc.dsw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.ufscar.dc.dsw.classes.User;
import br.ufscar.dc.dsw.dao.IBookingSiteDAO;
import br.ufscar.dc.dsw.dao.IHotelDAO;
import br.ufscar.dc.dsw.dao.IUserDAO;

public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private IUserDAO userDao;
    
    @Autowired
    private IHotelDAO hotelDao;
    
    @Autowired
    private IBookingSiteDAO bookingSiteDao;
     
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userDao.getUserByEmail(email);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new UserAccount(user);
    }
}
