package resources;

import pojo.AddBook;

public class TestDataBuild {

    public AddBook addBookPayload(String name, String isbn, String aisle, String author) {
        AddBook addBook = new AddBook();

        addBook.setName(name);
        addBook.setIsbn(isbn);
        addBook.setAisle(aisle);
        addBook.setAuthor(author);

        return addBook;
    }
}
