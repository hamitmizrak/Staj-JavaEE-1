package com.ecodation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecodation.dto.SocialMediaDto;

public class SocialMediaDao implements IDaoImplements<SocialMediaDto> {

	@Override
	public void create(SocialMediaDto socialMediaDto) {
		try (Connection connection = getInterfaceConnection()) {
			// String sql = "insert social(social_name,social_icon) values(?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert social(social_name,social_icon,social_url) values(?,?,?)");
			preparedStatement.setString(1, socialMediaDto.getSocialName());
			preparedStatement.setString(2, socialMediaDto.getSocialIcon());
			preparedStatement.setString(3, socialMediaDto.getSocialUrl());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("social media Eklendi. ");
			} else {
				System.out.println("social eklenmedi");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(SocialMediaDto socialMediaDto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "update social set social_name=?,social_icon=?,social_url=? where social_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, socialMediaDto.getSocialName());
			preparedStatement.setString(2, socialMediaDto.getSocialIcon());
			preparedStatement.setString(3, socialMediaDto.getSocialUrl());
			preparedStatement.setInt(4, socialMediaDto.getSocialId());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("social media Güncellendi. ");
			} else {
				System.out.println("social güncellenemedi");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "delete from social  where social_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("social media Silindi. ");
			} else {
				System.out.println("social silinmedi");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<SocialMediaDto> list() {
		ArrayList<SocialMediaDto> list = new ArrayList<SocialMediaDto>();
		SocialMediaDto mediaDto;

		try (Connection connection = getInterfaceConnection()) {
			String sql = "select *  from social order by social_id desc"; // limit 1
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mediaDto = new SocialMediaDto();
				mediaDto.setSocialId(resultSet.getInt("social_id"));
				mediaDto.setSocialIcon(resultSet.getString("social_icon"));
				mediaDto.setSocialName(resultSet.getString("social_name"));
				mediaDto.setSocialUrl(resultSet.getString("social_url"));
				mediaDto.setDate(resultSet.getDate("creation_date"));
				list.add(mediaDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		// SocialMediaDao dao = new SocialMediaDao();

		// SocialMediaDto socialMediaDto = new SocialMediaDto(0, "Facebook", "fas fa facebook");
		// dao.create(socialMediaDto);

		// SocialMediaDto socialMediaDto = new SocialMediaDto(0, "Facebook44", "fas fa faceboo44");
		// dao.update(socialMediaDto);

		// dao.delete(3);

		// ArrayList<SocialMediaDto> commonList = dao.list();
		// for (SocialMediaDto temp : commonList) {
		// System.out.println(temp);
		// }
	}

}
