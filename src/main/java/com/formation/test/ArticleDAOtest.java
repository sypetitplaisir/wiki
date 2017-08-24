package com.formation.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeoutException;

import org.junit.Test;

import com.formation.wiki.dao.ArticleDAO;
import com.formation.wiki.dao.ArticleNotExistException;

public class ArticleDAOtest {

	@Test (expected=TimeoutException.class)
	public void AjouterArticletest() throws TimeoutException{
		
		assertTrue(ArticleDAO.AjouterArticle("Article1", null , 1));
		assertTrue(ArticleDAO.AjouterArticle(null, "Contenu1" , 1));

	} 
	
	@Test
	public void RecupererListeArticleByIDtest() {
		
		assertEquals(0, ArticleDAO.RecupererListeArticleByID(852).size());
		
	}
	
	@Test
	public void RecupererListeArticleByNametest() {

		assertEquals(0, ArticleDAO.RecupererListeArticleByName("***").size());
		
	}
	
	@Test(expected = ArticleNotExistException.class)
	public void SupprimerArticletest () throws ArticleNotExistException {
		assertTrue(ArticleDAO.SupprimerArticle(5));
		assertFalse(ArticleDAO.SupprimerArticle(10000));
	}

	
}
