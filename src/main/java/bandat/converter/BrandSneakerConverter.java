package bandat.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import bandat.dto.BrandSneakerDTO;
import bandat.entity.BrandSneakerEntity;

@Component
public class BrandSneakerConverter {
	public BrandSneakerDTO convertToDTO(BrandSneakerEntity brandSneakerEntity) {
		 ModelMapper modelMapper=new ModelMapper();
		 BrandSneakerDTO brandSneakerDTO=modelMapper.map(brandSneakerEntity, BrandSneakerDTO.class);
		 return brandSneakerDTO;
	}
	public BrandSneakerEntity convertToEntity(BrandSneakerDTO brandSneakerDTO) {
		 ModelMapper modelMapper=new ModelMapper();
		 BrandSneakerEntity brandSneakerEntity=modelMapper.map(brandSneakerDTO, BrandSneakerEntity.class);
		 return brandSneakerEntity;
	}
}
