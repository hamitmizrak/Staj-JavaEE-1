package com.ecodation.dto;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "pass")
@RequestScoped

public class Pass {
	public void metotB() {
		Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String parametrelerim = param.get("parametre1");
		System.out.println(parametrelerim);
	}
}
