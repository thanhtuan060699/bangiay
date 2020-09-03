package bandat.api.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.BrandSneakerDTO;
import bandat.dto.SneakerDTO;
import bandat.service.impl.SneakerService;

@RestController
@RequestMapping(value = "/api/customer/sneaker")
public class CustomerSneakerAPI {
	@Autowired
	SneakerService sneakerService;
	
	@PostMapping
	@ResponseBody
	public SneakerDTO listSneakerByBrand(@RequestBody BrandSneakerDTO brandSneakerDTO) {
		List<SneakerDTO> sneakerDTOs=sneakerService.listSneakerByBrand(brandSneakerDTO.getId());
		return sneakerDTOs.get(0);
		
	}
}
