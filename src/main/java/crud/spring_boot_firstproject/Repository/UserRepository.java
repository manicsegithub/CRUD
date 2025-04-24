package crud.spring_boot_firstproject.Repository;

import crud.spring_boot_firstproject.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
