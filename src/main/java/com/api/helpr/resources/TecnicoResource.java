package com.api.helpr.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.helpr.domain.Tecnico;
import com.api.helpr.domain.dtos.TecnicoDTO;
import com.api.helpr.services.TecnicoService;

@RestController
@RequestMapping(value = "/service/tecnicos")
public class TecnicoResource {
	
	@Autowired
	private TecnicoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}
	
	@GetMapping(value="/all")
	public ResponseEntity<List<TecnicoDTO>> findAllTecnicos(){
		List<Tecnico> list = service.findAllTecnicos();
		List<TecnicoDTO> listDto = list.stream()
				.map(tec -> new TecnicoDTO(tec)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
