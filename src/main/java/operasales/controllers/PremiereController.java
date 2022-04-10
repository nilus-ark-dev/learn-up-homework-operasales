package operasales.controllers;

import operasales.dto.PremiereDto;
import operasales.services.Mapper;
import operasales.services.interfaces.PremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/premieres")
public class PremiereController {

    private PremiereService premiereService;
    private Mapper mapper;

    @Autowired
    public PremiereController(PremiereService premiereService, Mapper mapper) {
        this.premiereService = premiereService;
        this.mapper= mapper;
    }

    @GetMapping
    public Collection<PremiereDto> getAllPremieres()  {
        return premiereService.getAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PremiereDto getPremiere(@PathVariable("id") int id)  {
        return mapper.toDto(premiereService.getPremiere(id));
    }

    @PostMapping
    public void addPremiere(@RequestBody PremiereDto premiereDto) {
        premiereService.addPremiere(
                mapper.toDomain(premiereDto));
    }

    @PutMapping("/{id}")
    public void updatePremiere(@RequestBody PremiereDto premiereDto, @PathVariable("id") String id) {
        premiereService.updatePremiere(
                mapper.toDomain(premiereDto));
    }

    @DeleteMapping("/{id}")
    public void deletePremiere(@PathVariable("id") int id) {
        premiereService.deletePremiere(id);
    }
}
