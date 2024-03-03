package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.dto.requests.owner.OwnerSaveRequest;
import dev.patika.veterinary.dto.requests.owner.OwnerUpdateRequest;
import dev.patika.veterinary.dto.responses.owner.OwnerResponse;
import dev.patika.veterinary.entities.Owner;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IOwnerService {
    OwnerResponse save(OwnerSaveRequest owner);
    OwnerResponse get(Long id);
    Page<Owner> cursor(int page, int pageSize);
    void delete(Long id);
    OwnerResponse update(Long id, OwnerUpdateRequest ownerUpdateRequest);
    List<Owner> findByName(String name);
}
