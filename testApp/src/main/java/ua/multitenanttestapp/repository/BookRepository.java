package ua.multitenanttestapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.multitenanttestapp.models.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
