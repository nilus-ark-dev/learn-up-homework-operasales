package operasales.services;

import operasales.domain.PremiereMain;
import operasales.repository.interfaces.PremiereRepository;
import operasales.services.interfaces.PremiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.String;
import java.util.Collection;
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

    @Override
    public Collection<PremiereMain> getAll() {
        return premiereRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public PremiereMain getPremiere(int id) {
        return mapper.toDomain(
                premiereRepository.getById(String.valueOf(id)));
    }

    @Override
    public PremiereMain get(String title) {
        return mapper.toDomain(
                premiereRepository.get(title));
    }

    @Override
    public boolean addPremiere(PremiereMain premiereMain) {
        premiereRepository.save(mapper.toEvent(premiereMain));
        return true;
    }

    @Override
    public PremiereMain updatePremiere(PremiereMain premiereMain) {
        return mapper.toDomain(
                premiereRepository.save(
                        mapper.toEvent(premiereMain)));
    }

    @Override
    public void deletePremiere(int id) {
        premiereRepository.delete(id);
    }
}
