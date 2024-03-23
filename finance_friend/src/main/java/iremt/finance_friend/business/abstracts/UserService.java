package iremt.finance_friend.business.abstracts;

import java.util.List;

import iremt.finance_friend.entities.concretes.User;
import iremt.finance_friend.entities.dtos.UserRegistrationDto;

public interface UserService {

	List<User> getAll();
	User registerNewUser(UserRegistrationDto userDto);
}
