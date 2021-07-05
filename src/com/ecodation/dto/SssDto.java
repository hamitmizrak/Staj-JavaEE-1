package com.ecodation.dto;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.ecodation.common.CommonAttribute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Named("sssDto")
@SessionScoped
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SssDto extends CommonAttribute implements Serializable {
	private static final long serialVersionUID = 3319296173293242703L;

	private int sssId;
	private String header;
	private String content;
	private String url;

	// parametreli constructor
	public SssDto(String header, String content, String url) {
		this.header = header;
		this.content = content;
		this.url = url;
	}

	// public static void main(String[] args) {
	// SocialMediaDto dto = SocialMediaDto.builder().socialName("facebook").build();
	// System.out.println(dto);
	// }

}
