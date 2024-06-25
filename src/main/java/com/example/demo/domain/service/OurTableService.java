package com.example.demo.domain.service;

import com.example.demo.domain.model.OurTable;
import com.example.demo.domain.repository.OurTableRespository;

import java.util.List;

public interface OurTableService {

    public List<OurTable> findAll();

    public OurTable findById(long id);

    public OurTable save(OurTable ourTable);
}
