package ccom.pp.sun.spring_boot_security_01.security;

import ccom.pp.sun.spring_boot_security_01.dao.Hdfcuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityUserRepository extends JpaRepository<Hdfcuser, Long> {
    Optional<Hdfcuser> findByUsername(String username);

}
