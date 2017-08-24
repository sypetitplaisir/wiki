package com.formation.test;



import org.junit.Test;
import static org.junit.Assert.*;


import com.formation.wiki.dao.CommentaireDAO;
import com.formation.wiki.dao.CommentaireNotExistException;

public class CommentaireDAOtest {

	@Test
	public void AjouterCommentairetest() {
		assertTrue(CommentaireDAO.AjouterCommentaire(null, 0, 0));
	}
	
	@Test
	public void RecupererListeCommentaireParArticletest() {
		assertEquals(0, CommentaireDAO.RecupererListeCommentaireParArticle(10000).size());
	}
	
	@Test(expected = CommentaireNotExistException.class)
	public void SupprimerArticletest() throws CommentaireNotExistException {
		assertTrue(CommentaireDAO.SupprimerCommentaire(1000));
	}

}


