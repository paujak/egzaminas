package it.akademija.paujak.sandelys.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import it.akademija.paujak.sandelys.entity.Klientas;
import it.akademija.paujak.sandelys.model.KlientasDTO;
import it.akademija.paujak.sandelys.repository.KlientasRepository;
import it.akademija.paujak.sandelys.util.DTOtoEntityMapper;
import it.akademija.paujak.sandelys.util.EntityToDTOMapper;

@Service
public class KlientasService {
	
	private final EntityToDTOMapper entityToDTOMapper;
	private final DTOtoEntityMapper dtoToEntityMapper;
	private final KlientasRepository klientasRepository;
	
	public KlientasService(EntityToDTOMapper entityToDTOMapper, DTOtoEntityMapper dtoToEntityMapper,
			KlientasRepository klientasRepository) {
		this.entityToDTOMapper = entityToDTOMapper;
		this.dtoToEntityMapper = dtoToEntityMapper;
		this.klientasRepository = klientasRepository;
	}

	@Transactional
	public List<KlientasDTO> gautiVisusKlientus() {
		List<Klientas> klientai = klientasRepository.findAll();
		return klientai.stream()
				.map(entityToDTOMapper::klientasToDTO)
				.collect(Collectors.toList());
	}

	@Transactional
	public KlientasDTO gautiKlienta(Long id) {
		Optional<Klientas> klientas = klientasRepository.findById(id);
		return entityToDTOMapper.klientasToDTO(klientas.get());
	}

	@Transactional
	public KlientasDTO registruotiNaujaKlienta(KlientasDTO klientasDTO) {
		Klientas klientas = klientasRepository.save(dtoToEntityMapper.klientasDTOtoKlientas(klientasDTO));
		klientasDTO.setId(klientas.getId());
		return klientasDTO;
	}
	
	

}
