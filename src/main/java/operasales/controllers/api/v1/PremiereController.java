package operasales.controllers.api.v1;

import operasales.dto.PremiereDto;
import operasales.services.Mapper;
import operasales.services.interfaces.PremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/premieres")
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

    @GetMapping("/{title}")
    public PremiereDto getPremiere(@PathVariable("title") String title)  {
        return mapper.toDto(premiereService.getPremiere(title));
    }

    @PostMapping
    public void addPremiere(@RequestBody PremiereDto premiereDto) {
        premiereService.addPremiere(
                mapper.toDomain(premiereDto));
    }

    @PutMapping("/{id}")
    public void updatePremiere(@RequestBody PremiereDto premiereDto, @PathVariable("id") int id) {
        premiereService.updatePremiere(
                mapper.toDomain(premiereDto));
    }

    @DeleteMapping("/{id}")
    public void deletePremiere(@PathVariable("id") int id) {
        premiereService.deletePremiere(id);
    }
}
