package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.IAvailableDateService;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.dao.AvailableDateRepo;
import dev.patika.veterinary.dao.DoctorRepo;
import dev.patika.veterinary.dto.requests.availableDate.AvailableDateSaveRequest;
import dev.patika.veterinary.dto.responses.availableDate.AvailableDateResponse;
import dev.patika.veterinary.entities.AvailableDate;
import org.springframework.stereotype.Service;

@Service
public class AvailableDateManager implements IAvailableDateService {
    private final AvailableDateRepo availableDateRepo;
    private final IModelMapper modelMapper;
    private final DoctorRepo doctorRepo;

    public AvailableDateManager(AvailableDateRepo availableDateRepo, IModelMapper modelMapper, DoctorRepo doctorRepo) {
        this.availableDateRepo = availableDateRepo;
        this.modelMapper = modelMapper;
        this.doctorRepo = doctorRepo;
    }


    @Override
    public AvailableDateResponse save(AvailableDateSaveRequest availableDateSaveRequest) {
        AvailableDate availableDate = this.modelMapper.forRequest().map(availableDateSaveRequest, AvailableDate.class);
        availableDate.setDoctor(this.doctorRepo.findById(availableDateSaveRequest.getDoctorId()).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND)));
        this.availableDateRepo.save(availableDate);
        return this.modelMapper.forResponse().map(availableDate, AvailableDateResponse.class);
    }

    @Override
    public AvailableDateResponse get(Long id) {
        AvailableDate availableDate = this.availableDateRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(availableDate,AvailableDateResponse.class);
    }

    @Override
    public void delete(Long id) {
        AvailableDate availableDate = this.availableDateRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        this.availableDateRepo.delete(availableDate);
    }
}
