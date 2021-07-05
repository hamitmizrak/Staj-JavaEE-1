package com.ecodation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecodation.dto.SssDto;

import lombok.extern.java.Log;

@Log
public class SssDao implements IDaoImplements<SssDto> {

	@Override
	public void create(SssDto sssDto) {
		try (Connection connection = getInterfaceConnection()) {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert sss(header,content,url) values(?,?,?)");
			preparedStatement.setString(1, sssDto.getHeader());
			preparedStatement.setString(2, sssDto.getContent());
			preparedStatement.setString(3, sssDto.getUrl());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("sss  Eklendi. ");
				log.info(SssDao.class + " sss  Eklendi.");
			} else {
				System.out.println("sss eklenmedi");
				log.warning(SssDao.class + " sss  Eklendi.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(SssDto sssDto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "update sss set header=?,content=?,url=? where sss_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sssDto.getHeader());
			preparedStatement.setString(2, sssDto.getContent());
			preparedStatement.setString(3, sssDto.getUrl());
			preparedStatement.setInt(4, sssDto.getSssId());
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("sss  Güncellendi. ");
				log.info(SssDao.class + " sss  güncellendi.");
			} else {
				System.out.println("sss güncellenemedi");
				log.warning(SssDao.class + " sss  güncellenemedi.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "delete from sss  where sss_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rows = preparedStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("sss  Silindi. ");
				log.info(SssDao.class + " sss  silindi.");
			} else {
				System.out.println("sss silinmedi");
				log.warning(SssDao.class + " sss  silinmedi.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<SssDto> list() {
		ArrayList<SssDto> list = new ArrayList<SssDto>();
		SssDto mediaDto;
		try (Connection connection = getInterfaceConnection()) {
			String sql = "select *  from sss order by sss_id desc"; // limit 1
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mediaDto = new SssDto();
				mediaDto.setSssId(resultSet.getInt("sss_id"));
				mediaDto.setContent(resultSet.getString("content"));
				mediaDto.setHeader(resultSet.getString("header"));
				mediaDto.setUrl(resultSet.getString("url"));
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
