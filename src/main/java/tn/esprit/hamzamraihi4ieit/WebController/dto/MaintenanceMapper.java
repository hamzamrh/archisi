package tn.esprit.hamzamraihi4ieit.WebController.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.hamzamraihi4ieit.domaine.Maintenance;

@Mapper(componentModel = "spring")
public interface MaintenanceMapper {

    @Mapping(target = "idMaintenance", source = "idMaintenance")
    @Mapping(target = "idVehicule", source = "vehicule.idVehicule")
    MaintenanceDTO toDto(Maintenance maintenance);
}
