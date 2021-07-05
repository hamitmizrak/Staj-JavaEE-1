package com.ecodation.common;

import java.util.Date;

import lombok.Data;

@Data
public abstract class ImageUpload {
	// deneme.jpg
	private String imagePath;
	private String imageName;
	private String imageType;
	private Date imageDate;

}
