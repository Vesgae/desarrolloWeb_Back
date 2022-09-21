package com.javeriana.library.controller;

import com.javeriana.library.dto.Mensaje;
import com.javeriana.library.entity.Book;
import com.javeriana.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/Books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> Books = bookService.getBooks();
        return new ResponseEntity<List<Book>>(Books, HttpStatus.OK);
    }
    @GetMapping("Books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book currentBook = bookService.getBook(id).get();
        return new ResponseEntity<Book>(currentBook, HttpStatus.OK);
    }
    @DeleteMapping("/Books")
    public ResponseEntity<?> deleteBook(@RequestParam Long id){
        if (!bookService.existsByIdBook(id))
            return new ResponseEntity(new Mensaje("No existe el Libro"), HttpStatus.NOT_FOUND);
        bookService.deleteBook(id);
        return new ResponseEntity(new Mensaje("Libro eliminado"), HttpStatus.OK);
    }
    @PostMapping("/Books")
    public ResponseEntity<?> saveBook(@RequestBody Book book){
        bookService.saveBook(book);
        return new ResponseEntity(new Mensaje("Libro Creado"), HttpStatus.OK);
    }
    @PutMapping("/Books/{id}")
    public ResponseEntity updateBook(@PathVariable Long id, @RequestBody Book book){
        Book currentBook = bookService.getBook(id).get();
        currentBook.setAuthor(book.getAuthor());
        currentBook.setDescription(book.getDescription());
        currentBook.setTitle(book.getTitle());
        currentBook.setPublication_year(book.getPublication_year());
        bookService.saveBook(currentBook);
        return new ResponseEntity(new Mensaje("Libro Actualizado"), HttpStatus.OK);
    }
}
