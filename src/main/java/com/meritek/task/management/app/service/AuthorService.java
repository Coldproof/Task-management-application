package com.meritek.task.management.app.service;

import com.meritek.task.management.app.model.Author;
import com.meritek.task.management.app.repository.AuthorRepository;
import com.meritek.task.management.app.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
       this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author with ID " + id + " not found"));
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = getAuthorById(id);
        existingAuthor.setName(author.getName());
        existingAuthor.setEmail(author.getEmail());
        return authorRepository.save(existingAuthor);
    }

    public void deleteAuthor(Long id) {
        Author author = getAuthorById(id);
        authorRepository.delete(author);
    }
}
