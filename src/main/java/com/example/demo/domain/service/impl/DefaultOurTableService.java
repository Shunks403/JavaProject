package com.example.demo.domain.service.impl;

import com.example.demo.domain.model.OurTable;
import com.example.demo.domain.repository.OurTableRespository;
import com.example.demo.domain.service.OurTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultOurTableService implements OurTableService {
private final OurTableRespository ourTableRespository;
    @Override
    public List<OurTable> findAll() {
        return ourTableRespository.findAll();
    }

    @Override
    public OurTable findById(long id) {
        return ourTableRespository.findById(id);
    }

    @Override
    public OurTable save(OurTable ourTable) {
        return ourTableRespository.save(ourTable);
    }
}
