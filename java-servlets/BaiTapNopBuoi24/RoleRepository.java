package crm06.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crm06.config.MySQLConfig;
import crm06.entity.RoleEntity;

public class RoleRepository {
	public List<RoleEntity> getAll(){
		List<RoleEntity> roles = new ArrayList<RoleEntity>();
		
		try {
			String sql = "SELECT * FROM roles";
			ResultSet resultSet = getQueryResultSet(sql);
			
			while(resultSet.next()) {
				RoleEntity role = new RoleEntity();
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));
				
				roles.add(role);
			}
		} catch(Exception ex) {
			
		}
		
		return roles;
	}
	
	public void addRole(RoleEntity role) {
		try {
			String sql = "INSERT INTO roles(name, description) VALUES('"+role.getName()+"', '"+role.getDescription()+"')";
			executeQuery(sql);
			
		} catch(Exception ex) {
			
		}
	}
	
	private ResultSet getQueryResultSet(String sql) {
		ResultSet resultSet = null;
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			connection.close();
		} catch(Exception ex) {
			
		}
		
		return resultSet;
	}
	
	private void executeQuery(String sql) {
		try {
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.close();
		} catch(Exception ex) {
			
		}
	}
}
