package com.example.demo.domain.repository;

import com.example.demo.domain.model.OurTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OurTableRespository extends JpaRepository<OurTable, Long> {
    public List<OurTable> findAll();

    public OurTable findById(long id);

    public OurTable save(OurTable ourTable);
}
