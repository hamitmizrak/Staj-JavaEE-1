package com.ecodation.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;//servlet Path

import com.ecodation.common.ImagePath;
import com.ecodation.dao.BlogDao;
import com.ecodation.dao.IControllerImplements;
import com.ecodation.dto.BlogDto;

import lombok.extern.java.Log;

@Named(value = "blogController")
@SessionScoped
@Log
public class BlogController implements Serializable, IControllerImplements<BlogDto> {
	private static final long serialVersionUID = -8603164388296617493L;

	private BlogDto blogDto;
	private BlogDao blogDao;
	private ArrayList<BlogDto> list;
	private ArrayList<BlogDto> detailList;
	private ArrayList<BlogDto> categoriesList;

	// resim
	private Part part;

	public BlogController() {
		this.blogDao = new BlogDao();
		this.blogDto = new BlogDto();
		this.list = new ArrayList<>();
		list();

		this.detailList = new ArrayList<>();
		blogList();

	}

	public String blogCategories(String categories) {
		this.categoriesList = this.blogDao.categoriesList(categories);
		System.out.println(this.categoriesList);
		return "blog-categories.xhtml?faces-redirect=true";
	}

	public void blogDetails() throws IOException {
		Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id = param.get("blogId");
		this.detailList = this.blogDao.detailList(id);
		System.out.println(this.detailList);
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/blog-details.xhtml");
	}

	public ArrayList<BlogDto> blogList() {
		return this.detailList;
	}

	// create
	@Override
	public String create(BlogDto blogDto) {
		try {
			if (this.blogDto != null) {
				this.blogDto = new BlogDto();
				try (InputStream inputStream = part.getInputStream()) {
					// resim . jpg
					File file = new File(ImagePath.resimYolu, part.getSubmittedFileName());
					Files.copy(inputStream, file.toPath());
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					String change = file.getName().substring(file.getName().lastIndexOf("."));
					String newFileName = dateFormat.format(new Date()) + change;
					File file2 = new File(ImagePath.resimYolu, newFileName);
					file.renameTo(file2);
					blogDto.setCreationDate(new Date(System.currentTimeMillis()));
					blogDto.setImageName(file2.getName());
					blogDto.setImageType(part.getContentType());
					blogDto.setImagePath(file2.getParent());
					this.blogDao.create(blogDto);
					log.info("Ekleme controller ");

				} catch (Exception e) {
					e.printStackTrace();
					log.warning("Hata" + e);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "blog?faces-redirect=true";
	}

	// update
	@Override
	public String update(BlogDto t) {
		try {
			this.blogDao.update(t);
			log.info("Güncelleme controller ");
			this.blogDto = new BlogDto();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "blog?faces-redirect=true";
	}

	@Override
	public ArrayList<BlogDto> list() {
		try {
			this.list = this.blogDao.list();
			log.info("listeme controller ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// delete
	@Override
	public String delete(int id) {
		try {
			this.blogDao.delete(id);
			log.info("Silme controller ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "blog?faces-redirect=true";
	}

	@Override
	public String updateForm(BlogDto t) {
		// TODO Auto-generated method stub
		return "blog?faces-redirect=true";
	}

	@Override
	public String clear(BlogDto t) {
		// TODO Auto-generated method stub
		return "blog?faces-redirect=true";
	}

	// getter and setter
	public BlogDto getBlogDto() {
		if (this.blogDto == null)
			this.blogDto = new BlogDto();
		return blogDto;
	}

	public void setBlogDto(BlogDto blogDto) {
		this.blogDto = blogDto;
	}

	// Servlet resim
	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

}
