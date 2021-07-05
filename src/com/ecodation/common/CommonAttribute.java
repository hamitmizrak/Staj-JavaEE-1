package com.ecodation.common;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class CommonAttribute {
	private Date date;
}
