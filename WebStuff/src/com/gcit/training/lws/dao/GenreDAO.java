package com.gcit.training.lws.dao;



import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.training.lws.domain.Author;
import com.gcit.training.lws.domain.Genre;

public class GenreDAO extends BaseDAO<com.gcit.training.lws.domain.Genre> implements Serializable {

	public GenreDAO(Connection conn) {
		super(conn);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1619700647002508164L;

	public void addGenre(Genre genre) throws SQLException {

//		Integer pubId = null;
//		if (bk.getPublisher() != null)
//			pubId = bk.getPublisher().getId();
//
//		int bookId = saveWithId(
//				"insert into tbl_book (title, pubId) values (?)", new Object[] {
//						bk.getTitle(), pubId });
//
//		for (Author a : bk.getAuthors()) {
//			save("insert into tbl_book_authors (bookId, authorId) values (?,?)",
//					new Object[] { bookId, a.getAuthorId() });
//		}

		save("insert into tbl_genre ( genre_name ) values (?)",
				new Object[] { genre.getName() });
	
	}

	public void updateGenre(Genre genre) throws SQLException {
		save("update tbl_genre set genre_name = ? where genre_id = ?",
				new Object[] { genre.getName(), genre.getGenreId() });
	}

	public void removeGenre(Genre genre) throws SQLException {
		save("delete from tbl_genre where genre_id = ?",
				new Object[] { genre.getGenreId() });
	}

	@SuppressWarnings("unchecked")
	public List<Genre> readAll() throws SQLException {
		return (List<Genre>) read("select * from tbl_genre", null);
	}

	public Genre readOne(int genre_id) throws SQLException {
		return null;
	}

	@Override
	protected List<Genre> mapResults(ResultSet rs) throws SQLException {
		List<Genre> genres = new ArrayList<Genre>();
		PublisherDAO pDAO = new PublisherDAO(conn);
		AuthorDAO aDAO = new AuthorDAO(conn);
		
		while (rs.next()) {
			Genre b = new Genre();
			b.setGenreId(rs.getInt("genre_id"));
			b.setName(rs.getString("genre_name"));
			
			
			//List<Author> authors = (List<Author>) aDAO.readFirstLevel("select * from tbl_author where authorId in "
					//+ "(select authorId from tbl_genre_authors where genre_id = ?)", new Object[]{b.getGenreId()});
			//b.setAuthors(authors);
			
			genres.add(b);
		}
		return genres;
	}

	@Override
	protected List<Genre> mapResultsFirstLevel(ResultSet rs) throws SQLException {
		List<Genre> genres = new ArrayList<Genre>();
		PublisherDAO pDAO = new PublisherDAO(conn);
		AuthorDAO aDAO = new AuthorDAO(conn);
		
		while (rs.next()) {
			Genre b = new Genre();
			b.setGenreId(rs.getInt("genre_id"));
			b.setName(rs.getString("genre_name"));
			
			
			genres.add(b);
		}
		return genres;
	}
}

