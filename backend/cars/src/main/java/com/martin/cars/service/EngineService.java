package com.martin.cars.service;

import com.martin.cars.dto.CarDto;
import com.martin.cars.dto.EngineDto;
import com.martin.cars.dto.mappers.EngineMapper;
import com.martin.cars.exception.ResourceMissingException;
import com.martin.cars.exception.ResourceNotFoundException;
import com.martin.cars.model.CarModel;
import com.martin.cars.model.Engine;
import com.martin.cars.repository.EngineRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EngineService {

    private final EngineRepository engineRepository;
    private final EngineMapper engineMapper;
    private final CarModelService carModelService;

    public Engine findById(Long id){
        return engineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Engine with this ID doesn't exist."));
    }

    public EngineDto findByIdAsDto(Long id){
        return engineMapper.toDTO(findById(id));
    }

    @Transactional
    public EngineDto create(EngineDto engineDto){
        if (engineDto.getCarModel() == null || engineDto.getCarModel().getId() == null){
            throw  new ResourceMissingException("Car model or car model ID doesn't exist for this Engine.");
        }

        CarModel carModel = carModelService.findById(engineDto.getCarModel().getId());
        Engine engine = engineMapper.toEntity(engineDto);
        engine.setCarModel(carModel);

        return engineMapper.toDTO(engineRepository.save(engine));
    }

    @Transactional
    public EngineDto update(EngineDto engineDto){
        if (engineDto.getCarModel() == null || engineDto.getCarModel().getId() == null){
            throw  new ResourceMissingException("Car model or car model ID doesn't exist for this Engine.");
        }
        if (engineDto.getId() == null) {
            throw new ResourceMissingException("Engine ID is required for update.");
        }

        Engine engine = findById(engineDto.getId());
        CarModel carModel = carModelService.findById(engineDto.getCarModel().getId());

        Engine updatedEngine = engineMapper.updateEngineFromDto(engineDto, engine);
        updatedEngine.setCarModel(carModel);

        return engineMapper.toDTO(engineRepository.save(updatedEngine)) ;
    }

    @Transactional
    public EngineDto delete(Long id){
        Engine engine = findById(id);
        engineRepository.delete(engine);

        return engineMapper.toDTO(engine);
    }

    public List<EngineDto> getEngines (Sort sort){
        return engineMapper.toDTOList(engineRepository.findAll(sort));
    }
}
