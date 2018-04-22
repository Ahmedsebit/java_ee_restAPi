package com.pluralsight.bookstore.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.inject.Inject;

import com.pluralsight.bookstore.model.Book;
import com.pluralsight.bookstore.model.Language;
import com.pluralsight.bookstore.model.repository.BookRepository;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
// import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BookRepositoryTest{

    @Inject
    private BookRepository bookRepository;

    @Test(expected = Exception.class)
    public void findWIthInvalidId(){
        bookRepository.find(null);
    }

    @Test(expected = Exception.class)
    public void createInvalidBook(){
        Book book = new Book(null, "a description", 12F, "isbn", new Date(), 123, "http://blahblah", Language.ENGLISH);
        book = bookRepository.create(book);
        Long bookId = book.getId();

    }

    @Test
    public void create() throws Exception{
        //test count all
        assertEquals(Long.valueOf(0), bookRepository.countAll());
        assertEquals(0, bookRepository.findAll().size());
        //insert
        Book book = new Book("a title", "a description", 12F, "isbn", new Date(), 123, "http://blahblah", Language.ENGLISH);
        book = bookRepository.create(book);
        Long bookId = book.getId();
        // Checks the created book
        assertNotNull(bookId);
        //Find
        Book bookfound = bookRepository.find(bookId);
        //if the same book
        assertEquals("a title", bookfound.getTitle());
        //count all again
        assertEquals(Long.valueOf(1), bookRepository.countAll());
        assertEquals(1, bookRepository.findAll().size());

        //delete
        bookRepository.delete(bookId);
        //count all again after delete
        assertEquals(Long.valueOf(0), bookRepository.countAll());
        assertEquals(0, bookRepository.findAll().size());
    }

    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
            .addClass(BookRepository.class)
            .addClass(Book.class)
            .addClass(Language.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsManifestResource("META-INF/test-persistence.xml", "persistence.xml");
    }
}
