package com.martin.cars.service;

import com.martin.cars.dto.BrandDto;
import com.martin.cars.dto.mappers.BrandMapper;
import com.martin.cars.exception.ResourceMissingException;
import com.martin.cars.exception.ResourceNotFoundException;
import com.martin.cars.model.Brand;
import com.martin.cars.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public Brand findById(Long id){
        return brandRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Brand with this ID doesn't exist."));
    }

    public BrandDto findByIdAsDto(Long id){
        return brandMapper.toDTO(findById(id));
    }

    @Transactional
    public BrandDto create(BrandDto brandDto){
        Brand brand = brandMapper.toEntity(brandDto);

        return brandMapper.toDTO(brandRepository.save(brand));
    }
    @Transactional
    public BrandDto update(BrandDto brandDto){
        if (brandDto.getId() == null) {
            throw new ResourceMissingException("Brand ID is required for update.");
        }
        Brand brand = findById(brandDto.getId());
        Brand updatedBrand = brandMapper.updateBrandFromDto(brandDto, brand);

        return brandMapper.toDTO(brandRepository.save(updatedBrand));
    }
    @Transactional
    public BrandDto delete(Long id){
        Brand brand = findById(id);

        brandRepository.delete(brand);

        return brandMapper.toDTO(brand);
    }

    public List<BrandDto> getBrands(Sort sort) {
        return brandMapper.toDTOlist(brandRepository.findAll(sort));
    }
}
