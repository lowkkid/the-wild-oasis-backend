package com.github.lowkkid.thewildoasisbackend.cabin.service;

import com.github.lowkkid.thewildoasisbackend.cabin.model.CabinCreateRequest;
import com.github.lowkkid.thewildoasisbackend.cabin.model.CabinDTO;
import com.github.lowkkid.thewildoasisbackend.cabin.model.CabinEditRequest;
import java.util.List;

public interface CabinService {
    List<CabinDTO> getAll();
    CabinDTO getById(Long id);
    CabinDTO create(CabinCreateRequest cabinCreateRequest);
    CabinDTO update(Long id, CabinEditRequest request);
    void delete(Long id);
    boolean refreshCabinImages();
}
