package iremt.finance_friend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iremt.finance_friend.business.abstracts.UserService;
import iremt.finance_friend.dataAccess.abstracts.UserDao;
import iremt.finance_friend.entities.concretes.User;
import iremt.finance_friend.entities.dtos.UserRegistrationDto;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {
		return this.userDao.findAll();
	}

	@Override
	public User registerNewUser(UserRegistrationDto userDto) {
		User newUser = new User();
		newUser.setEmail(userDto.getEmail());
		newUser.setPassword(userDto.getPassword()); 
		newUser.setName(userDto.getName());
		newUser.setLastname(userDto.getLastname());
		return userDao.save(newUser);
	}
}
