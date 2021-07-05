package com.ecodation.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ecodation.dao.IControllerImplements;
import com.ecodation.dao.SssDao;
import com.ecodation.dto.SssDto;

import lombok.extern.java.Log;

@Named(value = "sssController")
@RequestScoped
@Log
public class SssController implements Serializable, IControllerImplements<SssDto> {
	private static final long serialVersionUID = -8603164388296617493L;

	private SssDto sssDto;
	private SssDao sssDao;
	private ArrayList<SssDto> list;

	public SssController() {
		this.sssDao = new SssDao();
		this.sssDto = new SssDto();
		this.list = new ArrayList<>();
		list();
	}

	@Override
	public String create(SssDto t) {
		try {
			if (this.sssDto != null) {
				this.sssDto = new SssDto();
				this.sssDao.create(t);
				log.info("Ekleme controller ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sss?faces-redirect=true";
	}

	@Override
	public String update(SssDto t) {
		try {
			this.sssDao.update(t);
			log.info("Güncelleme controller ");
			this.sssDto = new SssDto();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sss?faces-redirect=true";
	}

	@Override
	public ArrayList<SssDto> list() {
		try {
			this.list = this.sssDao.list();
			log.info("listeme controller ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String delete(int id) {
		try {
			this.sssDao.delete(id);
			log.info("Silme controller ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "sss?faces-redirect=true";
	}

	@Override
	public String updateForm(SssDto t) {
		// TODO Auto-generated method stub
		return "sss?faces-redirect=true";
	}

	@Override
	public String clear(SssDto t) {
		// TODO Auto-generated method stub
		return "sss?faces-redirect=true";
	}

	// getter and setter
	public SssDto getSssDto() {
		if (this.sssDto == null)
			this.sssDto = new SssDto();
		return sssDto;
	}

	public void setSssDto(SssDto sssDto) {
		this.sssDto = sssDto;
	}

}
