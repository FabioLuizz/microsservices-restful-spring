package br.com.fiap.application.repository;

import br.com.fiap.application.model.Annotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AnnotationRepository extends JpaRepository<Annotation, Long> {

    public Optional<Annotation> findByAddress(String address);



    List<Annotation> findByCollectionDate(LocalDate date);

    @Query("SELECT c FROM Annotation c WHERE c.city = :city")
    List<Annotation> findByCity(@Param("city") String city);

    @Query("SELECT c FROM Annotation c WHERE c.collectionDate = :collectionDate")
    List<Annotation> findByDate(@Param("collectionDate") LocalDate collectionDate);

}
