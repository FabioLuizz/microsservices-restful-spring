package br.com.fiap.application.service;

import br.com.fiap.application.dto.AnnotationRegisterDto;
import br.com.fiap.application.exception.ExceptionHandler;
import br.com.fiap.application.model.Annotation;
import br.com.fiap.application.repository.AnnotationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class AnnotationService {

    @Autowired
    private AnnotationRepository repository;

    public Annotation save(AnnotationRegisterDto annotationRegisterDto) {
        Annotation annotation = new Annotation();
        BeanUtils.copyProperties(annotationRegisterDto, annotation);
        return repository.save(annotation);
    }

    public Annotation findById(Long id) {
        Optional<Annotation> annotationOptional = repository.findById(id);

        if(annotationOptional.isPresent()) {
           return annotationOptional.get();
        } else {
            throw new ExceptionHandler("Agendamento não encontrado!");
        }
    }

    public List<Annotation> listAllAnnotations() {
        return repository.findAll();
    }

    public void delete(Long id) {
        Optional<Annotation> annotationOptional = repository.findById(id);

        if(annotationOptional.isPresent()) {
            repository.delete(annotationOptional.get());
        } else {
            throw new ExceptionHandler("Agendamento não encontrado!");
        }
    }

    public List<Annotation> findByDate(LocalDate date) {
        return repository.findByCollectionDate(date);
    }

    public Annotation update(Long id, AnnotationRegisterDto annotationRegisterDto) {
        Optional<Annotation> annotationOptional = repository.findById(id);

        if (annotationOptional.isPresent()) {
            Annotation existingAnnotation = annotationOptional.get();
            BeanUtils.copyProperties(annotationRegisterDto, existingAnnotation);
            return repository.save(existingAnnotation);
        } else {
            throw new ExceptionHandler("Agendamento não encontrado!");
        }
    }

    public Annotation findByAddress(Annotation annotation) {

        Optional<Annotation> annotationOptional = repository.findByAddress(annotation.getAddress());

        if(annotationOptional.isPresent()) {
            return annotationOptional.get();
        } else {
            throw new ExceptionHandler("Agendamento não encontrado!");
        }
    }

    public List<Annotation> findByCity(String city) {
        List<Annotation> annotations = repository.findByCity(city);
        if (annotations.isEmpty()) {
            throw new ExceptionHandler("Agendamento não encontrado!");
        }
        return annotations;
    }

    public List<Annotation> findBySchedule(LocalDate collectionDate) {
        List<Annotation> annotations = repository.findByDate(collectionDate);

        if(annotations.isEmpty()) {
            throw new ExceptionHandler("Agendamento não encontrado!");
        }

        return annotations;
    }

}
