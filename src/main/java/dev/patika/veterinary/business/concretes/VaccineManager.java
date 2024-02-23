package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.IVaccineService;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.dao.VaccineRepo;
import dev.patika.veterinary.entities.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;
    @Autowired
    public VaccineManager(VaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public Vaccine get(int id) {
        return this.vaccineRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        this.vaccineRepo.findById(Math.toIntExact(vaccine.getId()));
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public Page<Vaccine> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.vaccineRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        Vaccine vaccine = this.get(id);
        this.vaccineRepo.delete(vaccine);
        return true;
    }
}
