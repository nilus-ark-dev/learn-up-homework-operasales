package operasales.services;

import operasales.domain.PremiereMain;
import operasales.repository.interfaces.PremiereRepository;
import operasales.services.interfaces.PremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.lang.String;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PremiereServiceImpl implements PremiereService {

    private ConsoleLogger logger;

    private PremiereRepository premiereRepository;
    private Mapper mapper;

    @Autowired
    public PremiereServiceImpl(ConsoleLogger logger, PremiereRepository premiereRepository, Mapper mapper) {
        this.logger = logger;
        this.premiereRepository = premiereRepository;
        this.mapper = mapper;
    }

    public Map<String, PremiereMain> premiereMainCollection;

    @PreAuthorize("hasRole(\"USER\")")
    @Override
    public PremiereMain getPremiere(String title) {
        return mapper.toDomain(
                premiereRepository.getById(title));
    }


    @PreAuthorize("hasAnyRole(\"USER\", \"GUEST\")")
    @Override
    public Collection<PremiereMain> getAll() {
        return premiereRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole(\"ADMIN\")")
    @Override
    public boolean addPremiere(PremiereMain premiereMain) {
        premiereRepository.save(mapper.toEvent(premiereMain));
        return true;
    }

    @PreAuthorize("hasRole(\"ADMIN\")")
    @Override
    public PremiereMain updatePremiere(PremiereMain premiereMain) {
        return mapper.toDomain(
                premiereRepository.save(
                        mapper.toEvent(premiereMain)));
    }

    @PreAuthorize("hasRole(\"ADMIN\")")
    @Override
    public void deletePremiere(int id) {
        premiereRepository.delete(id);
    }
}
