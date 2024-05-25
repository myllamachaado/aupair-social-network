package com.network.aupair.mapper;

import com.network.aupair.dto.request.AupairRequestDTO;
import com.network.aupair.dto.response.AupairResponseDTO;
import com.network.aupair.models.Aupair;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AupairAssembler {

    private ModelMapper mapper;

    public AupairResponseDTO toResponseDTO(Aupair aupair) {
        return mapper.map(aupair, AupairResponseDTO.class);
    }

    public Aupair requestToModel(AupairRequestDTO aupairRequestDTO) {
        return mapper.map(aupairRequestDTO, Aupair.class);
    }

    public List<AupairResponseDTO> toCollection(List<Aupair> aupair){
        return aupair.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

}
