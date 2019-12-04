package com.fantasticCode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fantasticCode.entities.Countries;

public interface CountryRepository extends JpaRepository<Countries, Integer> {

}
