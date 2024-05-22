package com.network.aupair.aupair;

import com.network.aupair.aupair.dto.request.AupairRequestDTO;
import com.network.aupair.aupair.dto.response.AupairResponseDTO;
import com.network.aupair.aupair.mapper.AupairAssembler;
import com.network.aupair.aupair.models.Aupair;
import com.network.aupair.aupair.models.Country;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/aupair")
public class AupairController {

    private final AupairService aupairService;
    private final AupairAssembler aupairAssembler;

    public AupairController(AupairRepository aupairRepository,
                            AupairService aupairService,
                            AupairAssembler aupairAssembler) {
        this.aupairService = aupairService;
        this.aupairAssembler = aupairAssembler;
    }

    @GetMapping
    public ResponseEntity<List<AupairResponseDTO>> getAupairs(Pageable page){
        return ResponseEntity.ok(aupairAssembler.toCollection(aupairService.list()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AupairResponseDTO> getAupair(@PathVariable String id){
        return aupairService.getById(id).map(aupair -> ResponseEntity.ok(aupairAssembler.toResponseDTO(aupair)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AupairResponseDTO> saveAupair(@Valid @RequestBody AupairRequestDTO aupair){
        Aupair aupairModel = aupairAssembler.requestToModel(aupair);
        aupairModel.setAupairCountryId(new Country(aupair.getAupairCountry()));
        aupairModel.setCountryOfOriginId(new Country(aupair.getCountryOfOrigin()));
        return ResponseEntity.ok(aupairAssembler.toResponseDTO(aupairService.save(aupairModel)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AupairResponseDTO> editAupair(@PathVariable String id, @Valid @RequestBody AupairRequestDTO aupair){
        if(aupairService.getById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            Aupair aupairModel = aupairAssembler.requestToModel(aupair);
            aupairModel.setAupairId(id);
            aupairModel.setAupairCountryId(new Country(aupair.getAupairCountry()));
            aupairModel.setCountryOfOriginId(new Country(aupair.getCountryOfOrigin()));
            AupairResponseDTO response = aupairAssembler.toResponseDTO(aupairService.updateById(aupairModel, id));
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AupairResponseDTO> deleteAupair(@PathVariable String id){
        if(aupairService.getById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        else{
            aupairService.delete(id);
            return ResponseEntity.ok().build();
        }
    }
}
