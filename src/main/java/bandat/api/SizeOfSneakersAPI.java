package bandat.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.SizeOfSneakersDTO;
import bandat.service.impl.SizeOfSneakersService;

@RestController
@RequestMapping(value="/api/sneaker/size")
public class SizeOfSneakersAPI {
	@Autowired
	SizeOfSneakersService sizeOfSneakersService;
	
	@PostMapping
	public ResponseEntity<Void>  addSize(@RequestBody SizeOfSneakersDTO sizeOfSneakersDTO) {
		sizeOfSneakersService.addSize(sizeOfSneakersDTO);
		return ResponseEntity.noContent().build();
	}
}
