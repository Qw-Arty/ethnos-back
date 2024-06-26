package com.example.ethnobff.repository;

import com.example.ethnobff.model.Ethnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EthnosRepository extends JpaRepository<Ethnos, Long> {
}