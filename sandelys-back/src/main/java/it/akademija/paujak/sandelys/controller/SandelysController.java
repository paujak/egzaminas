package it.akademija.paujak.sandelys.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.akademija.paujak.sandelys.model.KlientaiListDTO;
import it.akademija.paujak.sandelys.model.KlientasDTO;
import it.akademija.paujak.sandelys.service.AtaskaitosService;
import it.akademija.paujak.sandelys.service.InventoriusService;
import it.akademija.paujak.sandelys.service.KlientasService;

@RestController
@RequestMapping("/sandelys/api")
public class SandelysController {
	
	private final KlientasService klientasService;
	private final InventoriusService inventoriusService;
	private final AtaskaitosService ataskaitosService;
	
	
	
	public SandelysController(KlientasService klientasService, InventoriusService inventoriusService,
			AtaskaitosService ataskaitosService) {
		this.klientasService = klientasService;
		this.inventoriusService = inventoriusService;
		this.ataskaitosService = ataskaitosService;
	}


	@PostMapping(value = "/klientai/registruoti")
	public ResponseEntity<KlientasDTO> registruotiNaujaKlienta(@RequestBody KlientasDTO klientasDTO){
		
		return ResponseEntity.ok(klientasDTO);
	}
	
	@GetMapping(value = "/klientai/")
	public ResponseEntity<KlientaiListDTO> gautiVisusKlientus(){
		
		return ResponseEntity.ok(klientasService.gautiVisusKlientus());
	}
	
	@GetMapping(value = "/klientai/{id}")
	public ResponseEntity<KlientasDTO> gautiKlienta(@PathVariable String id){
		return ResponseEntity.ok(klientasService.gautiKlienta(id));
	}

}
