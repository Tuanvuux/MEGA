package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.Connect;
import model.Mega;
import model.productType;

public class MegaService {
	
	//hiển thị ra màn hình tất cả các sản phẩm
	
	
	//hiển thị ra màn hình các sản phẩm theo trang
	
	//1. đếm số lượng sản phẩm
	public static int numberProduct() {
		try {
			Connection connection = Connect.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS SL FROM megas");
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("SL");
			}
			
			System.out.println("so luong san pham: " + rs.getInt("SL"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int numberCategory(int category_id) {
		try {
			Connection connection = Connect.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS SL FROM megas where category_id = "+category_id+"");
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("SL");
			}
			
			System.out.println("so luong san pham: " + rs.getInt("SL"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//2. phân trang
	
	public static ArrayList<productType> product_type() {
		ArrayList<productType> kieu = new ArrayList<productType>();
		try {
			Connection connection = Connect.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product_type");
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				productType trang = new productType();
				trang.setId(rs.getInt("product_type_id"));
				trang.setType(rs.getString("product_type"));
				
				
				kieu.add(trang);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kieu;
	}
	public static ArrayList<Mega> pagingcategory(int id) {
		ArrayList<Mega> soTrang = new ArrayList<Mega>();
		try {
			Connection connection = Connect.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM megas where product_type_id = ? ");
			preparedStatement.setInt(1, id);
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Mega trang = new Mega();
				trang.setId(rs.getInt("id"));
				trang.setProduct_name(rs.getString("product_name"));
				trang.setProduct_type_id(rs.getInt("product_type_id"));
				
				soTrang.add(trang);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soTrang;
	}
	
	public static ArrayList<Mega> All() {
		ArrayList<Mega> soTrang = new ArrayList<Mega>();
		try {
			Connection connection = Connect.openConnect();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM megas");
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Mega trang = new Mega();
				trang.setId(rs.getInt("id"));
				trang.setProduct_name(rs.getString("product_name"));
				trang.setProduct_type_id(rs.getInt("product_type_id"));
				
				soTrang.add(trang);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return soTrang;
	}
	
	// tìm sản phẩm theo mục <category>
}


