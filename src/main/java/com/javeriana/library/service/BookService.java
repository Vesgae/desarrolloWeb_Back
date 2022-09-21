package com.javeriana.library.service;

import com.javeriana.library.entity.Book;
import com.javeriana.library.entity.User;
import com.javeriana.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }
    public Optional<Book> getBook(Long id){
        return bookRepository.findById(id);

    }
    public boolean existsByIdBook(Long id){
        return bookRepository.existsById(id);
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public void saveBook(Book book){
        bookRepository.save(book);

    }
}
