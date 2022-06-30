package com.mutant.dna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mutant.dna.entity.TabDna;

 

public interface DnaRepository extends JpaRepository<TabDna, String> {

}
