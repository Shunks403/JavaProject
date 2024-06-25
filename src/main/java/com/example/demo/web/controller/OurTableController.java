package com.example.demo.web.controller;

import com.example.demo.domain.model.OurTable;
import com.example.demo.domain.service.OurTableService;
import com.example.demo.validation.OnCreate;
import com.example.demo.web.dto.OurTableDTO;
import com.example.demo.web.mapper.OurTableMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tables")
public class OurTableController {
    private final OurTableService ourTableService;
    private final OurTableMapper ourTableMapper;

    @GetMapping("/all")
    public ResponseEntity<List<OurTableDTO>> getTables() {
        List<OurTableDTO> OurTablesDTO = new ArrayList<>();
        for (OurTable ourTable : ourTableService.findAll()) {
            OurTablesDTO.add(ourTableMapper.toDto(ourTable));

        }
        return ResponseEntity.ok(OurTablesDTO);
    }


    @PostMapping("/add")
    @Validated(OnCreate.class)
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<OurTableDTO> creatTable(@Valid @RequestBody OurTableDTO ourTableDTO) {
        OurTable ourTable = ourTableService.save(ourTableMapper.fromDto(ourTableDTO));

        return ResponseEntity.ok(ourTableMapper.toDto(ourTable));
    }

}
