package com.example.Proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Proyecto.Model.Opinion;
import com.example.Proyecto.Model.Opinion.Id;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Id>{

}
