package org.javaeerecipes.chapter07.recipe07_06;

import org.javaeerecipes.chapter07.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juneau
 */
public class AuthorDAOStandard {

    public AuthorDAOStandard() {
    }

    public void queryBookAuthor() {
        String qry = "select id, firstname, lastname, bio from book_author";
        CreateConnection.loadProperties();
        try (Connection conn = CreateConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(qry);) {
            while (rs.next()) {
                int author_id = rs.getInt("ID");
                String first_name = rs.getString("FIRSTNAME");
                String last_name = rs.getString("LASTNAME");
                String bio = rs.getString("BIO");
                System.out.println(author_id + "\t" + first_name
                        + " " + last_name + "\t" + bio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

    }

    /**
     * Do not use this method in production, instead make use of
     * PreparedStatements
     *
     * @param first
     * @param last
     * @param bio
     */
    private void performCreate(String first, String last, String bio) {
        String sql = "INSERT INTO BOOK_AUTHOR VALUES("
                + "BOOK_AUTHOR_S.NEXTVAL, "
                + "'" + last.toUpperCase() + "', "
                + "'" + first.toUpperCase() + "', "
                + "'" + bio.toUpperCase() + "')";
        try (Connection conn = CreateConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Returns row-count or 0 if not successful
            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("-- Record created --");
            } else {
                System.out.println("!! Record NOT Created !!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    private void performUpdate(String first, String last, String bio) {
        String sql = "UPDATE BOOK_AUTHOR "
                + "SET bio = '" + bio.toUpperCase() + "' "
                + "WHERE lastname = '" + last.toUpperCase() + "' "
                + "AND firstname = '" + first.toUpperCase() + "'";
        try (Connection conn = CreateConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("-- Record Updated --");

            } else {
                System.out.println("!! Record NOT Updated !!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    private void performDelete(String first, String last) {
        String sql = "DELETE FROM BOOK_AUTHOR WHERE LASTNAME = '" + last.toUpperCase() + "' "
                + "AND FIRSTNAME = '" + first.toUpperCase() + "'";
        try (Connection conn = CreateConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("-- Record Deleted --");
            } else {
                System.out.println("!! Record NOT Deleted!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

    /**
     * Facade method for inserting Author objects into the BOOK_AUTHOR table
     *
     * @param author
     */
    public void insert(Author author) {
        performCreate(author.getFirst(),
                author.getLast(),
                author.getBio());
    }

    /**
     * Facade method for updating Author objects in the BOOK_AUTHOR table
     *
     * @param author
     */
    public void update(Author author) {
        this.performUpdate(author.getFirst(), author.getLast(), author.getBio());
    }

    /**
     * Facade method for deleting Author objects from the BOOK_AUTHOR table
     *
     * @param args
     */
    public void delete(Author author) {
        performDelete(author.getFirst(), author.getLast());
    }

    public static void main(String[] args) {
        AuthorDAOStandard authorDao = new AuthorDAOStandard();
        authorDao.queryBookAuthor();
        authorDao.performCreate("Joe", "Blow", "N/A");
        authorDao.performUpdate("Joe", "Blow", "Joes Bio");
        authorDao.queryBookAuthor();
        authorDao.performDelete("Joe", "Blow");
    }
}
