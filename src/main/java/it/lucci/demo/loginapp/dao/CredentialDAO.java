package it.lucci.demo.loginapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import it.lucci.demo.loginapp.dao.mapper.CredentialMapper;
import it.lucci.demo.loginapp.entity.Credential;

@Component
public class CredentialDAO {

	private static final String SQL_LOAD_CREDENTIAL_BY_USERNAME = "SELECT * FROM credential WHERE username = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Credential loadCredentialByUsername(String username) {
		return jdbcTemplate.queryForObject(SQL_LOAD_CREDENTIAL_BY_USERNAME, 
				new Object[] { username }, new CredentialMapper());
	}

}
