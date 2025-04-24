package com.example.book.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.book.dto.BookDTO;
import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {
     private final BookRepository bookRepository;
     private final ModelMapper modelMapper;

     public BookDTO readBook(Long id) {
          Book book = bookRepository.findById(id).get();
          return modelMapper.map(book, BookDTO.class);
     }

     public Long createBook(BookDTO dto) {
          Book book = modelMapper.map(dto, Book.class);
          return bookRepository.save(book).getBc();
     }

     public Long updateBook(BookDTO dto) {
          Book book = bookRepository.findById(dto.getBc()).get();
          book.setPrice(dto.getPrice());
          return bookRepository.save(book).getBc();
     }

     public void deleteBook(Long id) {
          bookRepository.deleteById(id);
     }
}
