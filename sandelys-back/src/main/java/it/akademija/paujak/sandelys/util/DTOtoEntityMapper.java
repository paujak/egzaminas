package it.akademija.paujak.sandelys.util;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.akademija.paujak.sandelys.entity.Klientas;
import it.akademija.paujak.sandelys.model.KlientasDTO;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface DTOtoEntityMapper {

	Klientas klientasDTOtoKlientas(KlientasDTO klientasDTO);

}
