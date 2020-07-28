package bandat.util;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UploadFileUtils {
	public final String root="/usr/var";
	
	public void writeOrUpdate(byte [] bytes,String path) {
		File file=new File(StringUtils.substringBeforeLast(root+path, "/"));
		if(!file.exists()) {
			file.mkdir();
		}
		try (FileOutputStream fileOutputStream=new FileOutputStream(new File(root+path))){
			fileOutputStream.write(bytes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
