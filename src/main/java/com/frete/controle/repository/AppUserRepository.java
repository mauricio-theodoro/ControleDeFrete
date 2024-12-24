package com.frete.controle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frete.controle.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    public AppUser findByEmail(String email);
}
