/*
package day9.service;

import day9.domain.User;
import day9.dto.UserResponse;
import day9.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  public User saveUser(UserResponse userResponse, String password) {
    User user = new User();
    user.setUserId(userResponse.getId());
    user.setName(userResponse.getName());
    user.setEmail(userResponse.getEmail());
    user.setCompany(userResponse.getCompany().getName());
    user.setPhone(userResponse.getPhone());
    user.setCity(userResponse.getAddress().getCity());
    user.setPassword(bCryptPasswordEncoder.encode(password));
    return userRepository.save(user);
  }
}
*/
