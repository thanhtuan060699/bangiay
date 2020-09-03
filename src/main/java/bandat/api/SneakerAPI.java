package bandat.api;

import java.util.Base64;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bandat.dto.SneakerDTO;
import bandat.service.impl.SneakerService;
import bandat.util.UploadFileUtils;

@RestController
@RequestMapping("/api/sneaker")
public class SneakerAPI {
	@Autowired 
	UploadFileUtils uploadFileUtils;
	
	@Autowired 
	SneakerService sneakerService;
	
	
	@PostMapping
	public @ResponseBody Integer uploadFile(@RequestBody SneakerDTO sneakerDTO){
		byte[] decodeBase64=Base64.getDecoder().decode(sneakerDTO.getBase64().getBytes());
		uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+sneakerDTO.getNameImage());
		if(sneakerService.findByName(sneakerDTO.getName())!=null)
			return 2;
		sneakerService.addSneaker(sneakerDTO);
		return 1;
	}
	@DeleteMapping
	public @ResponseBody Integer deleteSneaker(@RequestBody SneakerDTO sneakerDTO){
		sneakerService.deleteSneaker(sneakerDTO);
		return 1;
	}
	
//	@PutMapping
//	public @ResponseBody Integer updateSneaker(@RequestBody SneakerDTO sneakerDTO){
//		byte[] decodeBase64=Base64.getDecoder().decode(sneakerDTO.getBase64().getBytes());
//		uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+sneakerDTO.getNameImage());
//		if(sneakerService.findByName(sneakerDTO.getName())!=null)
//			return 2;
//		sneakerService.addSneaker(sneakerDTO);
//		return 1;
//	}
}
