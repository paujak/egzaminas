package it.akademija.paujak.sandelys.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import it.akademija.paujak.sandelys.entity.Inventorius;
import it.akademija.paujak.sandelys.entity.Klientas;
import it.akademija.paujak.sandelys.model.InventoriusDTO;
import it.akademija.paujak.sandelys.model.KlientasDTO;
import it.akademija.paujak.sandelys.repository.InventoriusRepository;
import it.akademija.paujak.sandelys.repository.KlientasRepository;
import it.akademija.paujak.sandelys.util.DTOtoEntityMapper;
import it.akademija.paujak.sandelys.util.EntityToDTOMapper;

@Service
public class InventoriusService {
	
	private final EntityToDTOMapper entityToDTOMapper;
	private final DTOtoEntityMapper dtoToEntityMapper;
	private final InventoriusRepository inventoriusRepository;
	private final KlientasRepository klientasRepository;

	public InventoriusService(EntityToDTOMapper entityToDTOMapper, DTOtoEntityMapper dtoToEntityMapper,
			InventoriusRepository inventoriusRepository, KlientasRepository klientasRepository) {
		super();
		this.entityToDTOMapper = entityToDTOMapper;
		this.dtoToEntityMapper = dtoToEntityMapper;
		this.inventoriusRepository = inventoriusRepository;
		this.klientasRepository = klientasRepository;
	}
	
	@Transactional
	public List<InventoriusDTO> gautiKlientoInventoriu(Long id) {
		List<Inventorius> inventoriusList = inventoriusRepository.getAllByCustomerId(id);
		return inventoriusList.stream()
				.map(entityToDTOMapper::inventoriusToDTO)
				.collect(Collectors.toList());
	}

	@Transactional
	public InventoriusDTO registruotiNaujaInventoriu(InventoriusDTO inventoriusDTO, Long klientasId) {
		Klientas klientas = klientasRepository.findById(klientasId).get();
		KlientasDTO klientasDTO = entityToDTOMapper.klientasToDTO(klientas);
		inventoriusDTO.setTalpinimoData(LocalDate.now());
		inventoriusDTO.setKlientas(klientasDTO);
		Inventorius inventorius = dtoToEntityMapper.inventoriusDTOtoInventorius(inventoriusDTO);
		inventorius.setKlientas(klientas);
		inventorius = inventoriusRepository.save(inventorius);
		inventoriusDTO.setId(inventorius.getId());
		return inventoriusDTO;
	}

}
