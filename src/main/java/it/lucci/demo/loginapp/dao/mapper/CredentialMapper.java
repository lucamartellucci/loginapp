package it.lucci.demo.loginapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.lucci.demo.loginapp.entity.Credential;

public class CredentialMapper implements RowMapper<Credential> {

	@Override
	public Credential mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Credential credential = new Credential();
		
		credential.setUsername(rs.getString("username"));
		credential.setPassword(rs.getString("password"));
		credential.setRole(rs.getString("role"));
		return credential;
	}

}
