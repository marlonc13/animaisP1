package com.faculdade.animaisapi.repository;

import com.faculdade.animaisapi.model.Animais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimaisRepository extends JpaRepository<Animais, UUID> {

}