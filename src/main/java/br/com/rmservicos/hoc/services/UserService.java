package br.com.rmservicos.hoc.services;

import br.com.rmservicos.hoc.entities.User;
import br.com.rmservicos.hoc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        if(userRepository.findByEmail(user.getEmail()) == null) {
            user.setDtIncl(new Date());
            return userRepository.save(user);
        }
       return null;
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public User update(User user) {
        user.setDtAlter(new Date());
        return userRepository.save(user);
    }

    public void delete(Integer id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
    }
}
