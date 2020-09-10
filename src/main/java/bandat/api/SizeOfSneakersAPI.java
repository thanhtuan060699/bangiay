package bandat.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.SizeOfSneakersDTO;
import bandat.service.impl.SizeOfSneakersService;

@RestController
@RequestMapping(value="/api/sneaker/size")
public class SizeOfSneakersAPI {
	@Autowired
	SizeOfSneakersService sizeOfSneakersService;
	
	@PostMapping
	public @ResponseBody Integer addSize(@RequestBody SizeOfSneakersDTO sizeOfSneakersDTO) {
		if(sizeOfSneakersService.findBySizeAndSneakerId(sizeOfSneakersDTO.getSize(), sizeOfSneakersDTO.getSneakerId())!=null)
			return 2;
		sizeOfSneakersService.addSize(sizeOfSneakersDTO);
		return 1;
	}
	
	@DeleteMapping
	public @ResponseBody Integer deleteSize(@RequestBody SizeOfSneakersDTO sizeOfSneakersDTO) {
		sizeOfSneakersService.delete(sizeOfSneakersDTO.getSizeIds());
		return 1;
	}
	
	@PutMapping
	public @ResponseBody Integer updateSize(@RequestBody SizeOfSneakersDTO sizeOfSneakersDTO) {
		System.out.println("update");
		return 1;
		
	}
	
	
}
