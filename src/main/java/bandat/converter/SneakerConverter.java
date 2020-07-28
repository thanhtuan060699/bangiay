package bandat.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import bandat.dto.SneakerDTO;
import bandat.entity.SneakerEntity;

@Component
public class SneakerConverter {
	public SneakerDTO convertToDTO(SneakerEntity sneakerEntity) {
		 ModelMapper modelMapper=new ModelMapper();
		 SneakerDTO sneakerDTO=modelMapper.map(sneakerEntity, SneakerDTO.class);
		 sneakerDTO.setNameImage(sneakerEntity.getImage());
		 return sneakerDTO;
	}
	public SneakerEntity convertToEntity(SneakerDTO sneakerDTO) {
		 ModelMapper modelMapper=new ModelMapper();
		 SneakerEntity sneakerEntity=modelMapper.map(sneakerDTO, SneakerEntity.class);
		 sneakerEntity.setImage(sneakerDTO.getNameImage());
		 return sneakerEntity;
	}
}
