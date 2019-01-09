package com.baldo.thelibrary.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.baldo.thelibrary.domain.Book;
import com.baldo.thelibrary.domain.BookCategory;
import com.baldo.thelibrary.services.BookService;

import java.math.BigDecimal;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

		loadBooks();

	}

	public void loadBooks() {
		Book book1 = new Book();
		book1.setIsbn("8809843495");
		book1.setTitle("Dieci Piccoli Indiani");
		book1.setPrice(BigDecimal.valueOf(10.5));
		book1.addCategory(BookCategory.LITERATURE_AND_FICTION);
		bookService.saveOrUpdate(book1);

		Book book2 = new Book();
		book2.setIsbn("8809848795");
		book2.setTitle("Assassinio sull'Orient Express");
		book2.setPrice(BigDecimal.valueOf(15.2));
		book2.addCategory(BookCategory.LITERATURE_AND_FICTION);
		bookService.saveOrUpdate(book2);

		Book book3 = new Book();
		book3.setIsbn("8809848789");
		book3.setTitle("Harry Potter");
		book3.setPrice(BigDecimal.valueOf(15.45));
		book3.addCategory(BookCategory.LITERATURE_AND_FICTION);
		book3.addCategory(BookCategory.HISTORY);
		bookService.saveOrUpdate(book3);

	}

}
