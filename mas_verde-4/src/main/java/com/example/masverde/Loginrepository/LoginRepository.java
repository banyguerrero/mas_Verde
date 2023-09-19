package com.example.masverde.Loginrepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.masverde.modelo.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{
    Login findByUsernameAndPassword(String correo, String contraseña);
}