package org.javaeerecipes.chapter17;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import org.javaeerecipes.jpa.entity.BookAuthor;
import org.javaeerecipes.jpa.session.BookAuthorFacade;

@ManagedBean(name = "jsonController")
public class JsonController {

    @EJB
    BookAuthorFacade bookAuthorFacade;
    private String authorJson;

    public void buildAuthors() {
        List<BookAuthor> authors = bookAuthorFacade.findAll();
        JsonObjectBuilder builder = Json.createObjectBuilder();
        StringBuilder json = new StringBuilder();
        JsonObjectBuilder object = null;
        try (StringWriter sw = new StringWriter();) {
            for (BookAuthor author : authors) {
                System.out.println("author" + author.getLast());
                builder.add("author", Json.createObjectBuilder()
                        .add("authorId", author.getId())
                        .add("first", author.getFirst())
                        .add("last", author.getLast())
                        .add("bio", author.getBio()));

            }
            JsonObject result = builder.build();

            try (JsonWriter writer = Json.createWriter(sw)) {
                writer.writeObject(result);
            }
            json.append(sw.toString());
            authorJson = json.toString();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public String buildAndReturnAuthors() {
        List<BookAuthor> authors = bookAuthorFacade.findAll();
        JsonObjectBuilder builder = Json.createObjectBuilder();
        StringBuilder json = new StringBuilder();
        JsonObjectBuilder object = null;
        for (BookAuthor author : authors) {
            object = builder.add("authorId", author.getId())
                    .add("first", author.getFirst())
                    .add("last", author.getLast())
                    .add("bio", author.getBio());

        }
        builder.add("author", object);
        JsonObject result = builder.build();
        StringWriter sw = new StringWriter();
        try (JsonWriter writer = Json.createWriter(sw)) {
            writer.writeObject(result);
        }
        json.append(sw.toString());
        return json.toString();
    }

    public JsonObject buildAuthorsJson() {
        List<BookAuthor> authors = bookAuthorFacade.findAll();
        JsonObjectBuilder builder = Json.createObjectBuilder();
        StringBuilder json = new StringBuilder();
        JsonObjectBuilder object = null;;
        for (BookAuthor author : authors) {
            object = builder.add("authorId", author.getId())
                    .add("first", author.getFirst())
                    .add("last", author.getLast())
                    .add("bio", author.getBio());
        }
        builder.add("author", object);
        JsonObject result = builder.build();

        return result;
    }

    /**
     * @return the authorJson
     */
    public String getAuthorJson() {
        return authorJson;
    }

    /**
     * @param authorJson the authorJson to set
     */
    public void setAuthorJson(String authorJson) {
        this.authorJson = authorJson;
    }
}
