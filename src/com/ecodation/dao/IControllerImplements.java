package com.ecodation.dao;

import java.util.ArrayList;

public interface IControllerImplements<T> {

	String create(T t);

	String delete(int id);

	String update(T t);

	ArrayList<T> list();

	String updateForm(T t);

	String clear(T t);

}
