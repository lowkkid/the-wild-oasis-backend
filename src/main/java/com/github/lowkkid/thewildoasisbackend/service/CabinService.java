package com.github.lowkkid.thewildoasisbackend.service;

import com.github.lowkkid.thewildoasisbackend.dto.CabinDTO;

import java.util.List;

public interface CabinService {
    List<CabinDTO> getAll();
    CabinDTO getById(Long id);
    CabinDTO create(CabinDTO cabinDTO);
    CabinDTO update(Long id, CabinDTO cabinDTO);
    void delete(Long id);
}
