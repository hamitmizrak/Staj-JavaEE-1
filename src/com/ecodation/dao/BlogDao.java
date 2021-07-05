package com.ecodation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Shift+Alt+R
import com.ecodation.dto.BlogDto;

public class BlogDao implements IDaoImplements<BlogDto> {

	@Override
	public void create(BlogDto blogDto) {
		try (Connection connection = getInterfaceConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert blog(header,content,blog_categories,image_type,image_name,image_path) values(?,?,?,?,?,?)");
			preparedStatement.setString(1, blogDto.getHeader());
			preparedStatement.setString(2, blogDto.getContent());
			preparedStatement.setString(3, blogDto.getCategories());
			preparedStatement.setString(4, blogDto.getImageType());
			preparedStatement.setString(5, blogDto.getImageName());
			preparedStatement.setString(6, blogDto.getImagePath());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("blog media Eklendi. ");
			} else {
				System.out.println("blog eklenmedi");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(BlogDto blogDto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "update blog set header=?,content=?,blog_categories=?,image_type=?,image_name=?,image_path=? where blog_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, blogDto.getHeader());
			preparedStatement.setString(2, blogDto.getContent());
			preparedStatement.setString(3, blogDto.getCategories());
			preparedStatement.setString(4, blogDto.getImageType());
			preparedStatement.setString(5, blogDto.getImageName());
			preparedStatement.setString(6, blogDto.getImagePath());
			preparedStatement.setInt(7, blogDto.getBlogId());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("blog media Güncellendi. ");
			} else {
				System.out.println("blog güncellenemedi");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try (Connection connection = getInterfaceConnection()) {
			// deleteImage(id);
			String sql = "delete from blog  where blog_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("blog media Silindi. ");
			} else {
				System.out.println("blog silinmedi");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void deleteImage(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<BlogDto> list() {
		ArrayList<BlogDto> list = new ArrayList<BlogDto>();
		BlogDto mediaDto;

		try (Connection connection = getInterfaceConnection()) {
			String sql = "select *  from blog order by blog_id desc";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mediaDto = new BlogDto();
				mediaDto.setBlogId(resultSet.getInt("blog_id"));
				mediaDto.setHeader(resultSet.getString("header"));
				mediaDto.setContent(resultSet.getString("content"));
				mediaDto.setCategories(resultSet.getString("blog_categories"));
				mediaDto.setImageName(resultSet.getString("image_name"));
				mediaDto.setImagePath(resultSet.getString("image_path"));
				mediaDto.setImageType(resultSet.getString("image_type"));
				mediaDto.setImageDate(resultSet.getDate("creation_date"));
				list.add(mediaDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BlogDto> detailList(String id) {
		ArrayList<BlogDto> list = new ArrayList<BlogDto>();
		BlogDto mediaDto;

		try (Connection connection = getInterfaceConnection()) {
			String sql = "select *  from blog where blog_id=" + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mediaDto = new BlogDto();
				mediaDto.setBlogId(resultSet.getInt("blog_id"));
				mediaDto.setHeader(resultSet.getString("header"));
				mediaDto.setContent(resultSet.getString("content"));
				mediaDto.setCategories(resultSet.getString("blog_categories"));
				mediaDto.setImageName(resultSet.getString("image_name"));
				mediaDto.setImagePath(resultSet.getString("image_path"));
				mediaDto.setImageType(resultSet.getString("image_type"));
				mediaDto.setImageDate(resultSet.getDate("creation_date"));
				list.add(mediaDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<BlogDto> categoriesList(String categories) {
		ArrayList<BlogDto> list = new ArrayList<BlogDto>();
		BlogDto mediaDto;
		try (Connection connection = getInterfaceConnection()) {
			String sql = "select * from blog where blog_categories=" + "\"" + categories + "\"";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mediaDto = new BlogDto();
				mediaDto.setBlogId(resultSet.getInt("blog_id"));
				mediaDto.setHeader(resultSet.getString("header"));
				mediaDto.setContent(resultSet.getString("content"));
				mediaDto.setCategories(resultSet.getString("blog_categories"));
				mediaDto.setImageName(resultSet.getString("image_name"));
				mediaDto.setImagePath(resultSet.getString("image_path"));
				mediaDto.setImageType(resultSet.getString("image_type"));
				mediaDto.setImageDate(resultSet.getDate("creation_date"));
				list.add(mediaDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
