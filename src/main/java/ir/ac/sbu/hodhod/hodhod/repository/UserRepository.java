package ir.ac.sbu.hodhod.hodhod.repository;

import ir.ac.sbu.hodhod.hodhod.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

}
