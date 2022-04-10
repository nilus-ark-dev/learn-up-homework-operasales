package operasales.services;

import operasales.domain.PremiereMain;
import operasales.dto.PremiereDto;
import operasales.events.Premiere;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    PremiereDto toDto(PremiereMain premiereMain);
    PremiereMain toDomain(PremiereDto premiereDto);

    PremiereMain toDomain(Premiere premiere);
    Premiere toEvent(PremiereMain premiereMain);
}
