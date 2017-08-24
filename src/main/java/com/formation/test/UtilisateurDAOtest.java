package com.formation.test;

import static org.junit.Assert.*;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.formation.wiki.dao.UtilisateurDAO;

public class UtilisateurDAOtest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	//@Test(expected = CommunicationsException.class)
	@Test
	public static void isUserExisttest() throws SQLException, TimeoutException, ConnectException {
		/*
		assertTrue(UtilisateurDAO.isUserExist("",""));
		assertTrue(UtilisateurDAO.isUserExist("**","_*"));
		assertFalse(UtilisateurDAO.isUserExist("NOK",""));
		assertFalse(UtilisateurDAO.isUserExist(null,null));
		assertFalse(UtilisateurDAO.isUserExist("aaa",null));
		assertFalse(UtilisateurDAO.isUserExist("aaa","aaa"));
		assertFalse(UtilisateurDAO.isUserExist("0","--*--"));
		*/
		//exception.expect(AssertionError.class);
	}
	
	@Test
	public static void  insertUsertest() {
		assertTrue(UtilisateurDAO.insertUser(null, "1234", "toto", "titi", "toto@gmail.com", "112233445566"));
	}
	
}
