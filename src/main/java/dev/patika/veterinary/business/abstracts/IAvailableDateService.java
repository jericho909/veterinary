package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.dto.requests.availableDate.AvailableDateSaveRequest;
import dev.patika.veterinary.dto.responses.availableDate.AvailableDateResponse;

public interface IAvailableDateService {
    AvailableDateResponse save(AvailableDateSaveRequest availableDateSaveRequest);
    AvailableDateResponse get(Long id);
    void delete(Long id);
}
