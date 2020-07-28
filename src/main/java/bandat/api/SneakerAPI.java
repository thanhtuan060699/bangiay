package bandat.api;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Void> uploadFile(@RequestBody SneakerDTO sneakerDTO){
		byte[] decodeBase64=Base64.getDecoder().decode(sneakerDTO.getBase64().getBytes());
		uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+sneakerDTO.getNameImage());
		sneakerService.addSneaker(sneakerDTO);
		return ResponseEntity.noContent().build();
	}
}
