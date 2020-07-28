package bandat.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.BrandSneakerDTO;
import bandat.service.impl.BrandSneakerService;

@RestController

@RequestMapping(value = "/api/brandsneaker")
public class BrandSneakerAPI {
	@Autowired
	BrandSneakerService brandSneakerService;
	
	
	@PostMapping
	public  @ResponseBody Integer addBrand(@RequestBody BrandSneakerDTO brandSneakerDTO){
		if(brandSneakerService.findByBrandName(brandSneakerDTO.getName())==null) {
			brandSneakerService.addBrand(brandSneakerDTO);
			return 1;
		}
		
		return 2;
	}
}
