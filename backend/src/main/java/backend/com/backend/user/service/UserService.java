package backend.com.backend.user.service;

import backend.com.backend.user.entity.User;
import backend.com.backend.user.repository.UserRepository;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){//추가해야함
        userRepository.save(user);
        return user;
    }
    public User updateUser(Long userId,User user){//추가 해야함
        return user;
    }
    public User findUser(Long userId){

        return findVerifiedUser(userId);
    }
    public User deleteUser(Long userId){
        User finduser = findVerifiedUser(userId);
        finduser.setUser_status(User.UserStatus.USER_QUIT);
        return finduser;
    }
    public User findVerifiedUser(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        User finduser = optionalUser.orElseThrow(IllegalArgumentException::new);
        return finduser;
    }
}
