package dev.patika.veterinary.core.config.modelMapper;

import org.modelmapper.ModelMapper;

public interface IModelMapper {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
