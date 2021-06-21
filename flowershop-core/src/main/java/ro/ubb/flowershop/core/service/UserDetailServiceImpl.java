package ro.ubb.flowershop.core.service;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.flowershop.core.model.Employee;
import ro.ubb.flowershop.core.repository.EmployeeRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);

        if(employee == null) {
              throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
        return UserDetailsImpl.build(employee);
    }
}
