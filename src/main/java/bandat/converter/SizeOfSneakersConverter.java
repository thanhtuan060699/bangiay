package bandat.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import bandat.dto.SizeOfSneakersDTO;
import bandat.entity.SizeOfSneakersEntity;

@Component
public class SizeOfSneakersConverter {
	public SizeOfSneakersDTO convertToDTO(SizeOfSneakersEntity sizeOfSneakersEntity) {
		 ModelMapper modelMapper=new ModelMapper();
		 SizeOfSneakersDTO sizeOfSneakersDTO=modelMapper.map(sizeOfSneakersEntity, SizeOfSneakersDTO.class);
		 return sizeOfSneakersDTO;
	}
	public SizeOfSneakersEntity convertToEntity(SizeOfSneakersDTO sizeOfSneakersDTO) {
		 ModelMapper modelMapper=new ModelMapper();
		 SizeOfSneakersEntity sizeOfSneakersEntity=modelMapper.map(sizeOfSneakersDTO, SizeOfSneakersEntity.class);
		 return sizeOfSneakersEntity;
	}
}
