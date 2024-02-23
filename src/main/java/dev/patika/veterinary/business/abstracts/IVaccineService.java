package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.entities.Vaccine;
import org.springframework.data.domain.Page;

public interface IVaccineService {
    Vaccine save(Vaccine vaccine);
    Vaccine get(int id);
    Vaccine update(Vaccine vaccine);
    Page<Vaccine> cursor(int page, int pageSize);
    boolean delete(int id);
}
