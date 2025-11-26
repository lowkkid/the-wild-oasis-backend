package com.github.lowkkid.thewildoasisbackend.service;

import com.github.lowkkid.thewildoasisbackend.dto.CabinCreateRequest;
import com.github.lowkkid.thewildoasisbackend.dto.CabinDTO;
import com.github.lowkkid.thewildoasisbackend.dto.CabinEditRequest;
import java.util.List;

public interface CabinService {
    List<CabinDTO> getAll();
    CabinDTO getById(Long id);
    CabinDTO create(CabinCreateRequest cabinCreateRequest);
    CabinDTO update(Long id, CabinEditRequest request);
    void delete(Long id);
    boolean refreshCabinImages();
}
