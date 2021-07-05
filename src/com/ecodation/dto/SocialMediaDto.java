package com.ecodation.dto;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.ecodation.common.CommonAttribute;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Named("socialMediaDto")
@SessionScoped
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialMediaDto extends CommonAttribute implements Serializable {
	private static final long serialVersionUID = 3319296173293242703L;

	private int socialId;
	private String socialName;
	private String socialIcon;
	private String socialUrl;

	public SocialMediaDto(String socialName, String socialIcon, String socialUrl) {
		this.socialName = socialName;
		this.socialIcon = socialIcon;
		this.socialUrl = socialUrl;
	}

	// public static void main(String[] args) {
	// SocialMediaDto dto = SocialMediaDto.builder().socialName("facebook").build();
	// System.out.println(dto);
	// }

}
