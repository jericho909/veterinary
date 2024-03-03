package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.IOwnerService;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.dao.OwnerRepo;
import dev.patika.veterinary.dto.requests.owner.OwnerSaveRequest;
import dev.patika.veterinary.dto.requests.owner.OwnerUpdateRequest;
import dev.patika.veterinary.dto.responses.owner.OwnerResponse;
import dev.patika.veterinary.entities.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerManager implements IOwnerService {
    private final OwnerRepo ownerRepo;
    private final IModelMapper modelMapper;

    public OwnerManager(OwnerRepo ownerRepo, IModelMapper modelMapper) {
        this.ownerRepo = ownerRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public OwnerResponse save(OwnerSaveRequest ownerSaveRequest) {
        Owner newOwner = this.modelMapper.forRequest().map(ownerSaveRequest, Owner.class);
        this.ownerRepo.save(newOwner);
        return this.modelMapper.forResponse().map(newOwner, OwnerResponse.class);
    }

    @Override
    public OwnerResponse get(Long id) {
        Owner owner = this.ownerRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(owner, OwnerResponse.class);
    }

    @Override
    public Page<Owner> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.ownerRepo.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        Owner ownerToBeDeleted = this.ownerRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        this.ownerRepo.delete(ownerToBeDeleted);
    }

    @Override
    public OwnerResponse update(Long id, OwnerUpdateRequest ownerUpdateRequest) {
        Owner updatedOwner = this.ownerRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        updatedOwner.setName(ownerUpdateRequest.getName());
        updatedOwner.setEmail(ownerUpdateRequest.getEmail());
        updatedOwner.setPhone(ownerUpdateRequest.getPhone());
        updatedOwner.setAddress(ownerUpdateRequest.getAddress());
        updatedOwner.setCity(ownerUpdateRequest.getCity());

        return this.modelMapper.forResponse().map(this.ownerRepo.save(updatedOwner), OwnerResponse.class);
    }

    @Override
    public List<Owner> findByName(String name) {
        return this.ownerRepo.findByName(name);
    }

}
