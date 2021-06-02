package com.hrms.hrms.core.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager implements CloudService{
	
	Cloudinary cloudinary;
	
	private Map<String, String> valuesMap = new HashMap<>();
	
	public CloudinaryManager() {
		valuesMap.put("cloud_name", "dfoyfzmdb");
		valuesMap.put("api_key", "849664888142964");
		valuesMap.put("api_secret", "z7fGvjp3sA7uoQXoxRDfu4o8UO4");
		cloudinary = new Cloudinary(valuesMap);
	}

	@Override
	public Map upload(MultipartFile multipartFile) throws IOException {
		
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream stream = new FileOutputStream(file);
		stream.write(multipartFile.getBytes());
		stream.close();
		
		Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		
		return result;
	}

}
