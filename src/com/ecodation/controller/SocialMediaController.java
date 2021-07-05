package com.ecodation.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ecodation.dao.IControllerImplements;
import com.ecodation.dao.SocialMediaDao;
import com.ecodation.dto.SocialMediaDto;

import lombok.extern.java.Log;

@Named(value = "socialMediaController")
@RequestScoped
@Log
public class SocialMediaController implements Serializable, IControllerImplements<SocialMediaDto> {
	private static final long serialVersionUID = -8603164388296617493L;

	private SocialMediaDto socialMediaDto;
	private SocialMediaDao socialMediaDao;
	private ArrayList<SocialMediaDto> list;

	public SocialMediaController() {
		this.socialMediaDao = new SocialMediaDao();
		this.socialMediaDto = new SocialMediaDto();
		this.list = new ArrayList<>();
		list();
	}

	@Override
	public String create(SocialMediaDto t) {
		try {
			if (this.socialMediaDto != null) {
				this.socialMediaDto = new SocialMediaDto();
				this.socialMediaDao.create(t);
				log.info("Ekleme controller ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "social-media?faces-redirect=true";
	}

	@Override
	public String update(SocialMediaDto t) {
		try {
			this.socialMediaDao.update(t);
			log.info("Güncelleme controller ");
			this.socialMediaDto = new SocialMediaDto();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "social-media?faces-redirect=true";
	}

	@Override
	public ArrayList<SocialMediaDto> list() {
		try {
			this.list = this.socialMediaDao.list();
			log.info("listeme controller ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String delete(int id) {
		try {
			this.socialMediaDao.delete(id);
			log.info("Silme controller ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "social-media?faces-redirect=true";
	}

	@Override
	public String updateForm(SocialMediaDto t) {
		// TODO Auto-generated method stub
		return "social-media?faces-redirect=true";
	}

	@Override
	public String clear(SocialMediaDto t) {
		// TODO Auto-generated method stub
		return "social-media?faces-redirect=true";
	}

	// getter and setter
	public SocialMediaDto getSocialMediaDto() {
		if (this.socialMediaDto == null)
			this.socialMediaDto = new SocialMediaDto();
		return socialMediaDto;
	}

	public void setSocialMediaDto(SocialMediaDto socialMediaDto) {
		this.socialMediaDto = socialMediaDto;
	}

}
