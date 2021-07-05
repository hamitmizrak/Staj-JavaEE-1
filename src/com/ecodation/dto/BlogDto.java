package com.ecodation.dto;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.ecodation.common.ImageUpload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//C.D.I
@Named(value = "blog")
@ApplicationScoped

// Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BlogDto extends ImageUpload implements Serializable {
	private static final long serialVersionUID = 5761069806334710522L;

	private int blogId;
	private String header = "";
	private String content = "";
	private Date creationDate;
	private String categories = "";

}
