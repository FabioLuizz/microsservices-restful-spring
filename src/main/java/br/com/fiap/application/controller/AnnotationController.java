package br.com.fiap.application.controller;

import br.com.fiap.application.dto.AnnotationRegisterDto;
import br.com.fiap.application.model.Annotation;
import br.com.fiap.application.service.AnnotationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/collect")
public class AnnotationController {


    @Autowired
    private AnnotationService service;

    @PostMapping("/schedule")
    @ResponseStatus(HttpStatus.CREATED)
    public Annotation save(@RequestBody @Valid AnnotationRegisterDto annotationRegisterDto) {
        return service.save(annotationRegisterDto);
    }

    @GetMapping("/schedule")
    @ResponseStatus(HttpStatus.OK)
    public List<Annotation> listAllAnnotations() {
        return service.listAllAnnotations();
    }

    @GetMapping("/schedule/city/{city}")
    @ResponseStatus(HttpStatus.OK)
    public List<Annotation> findByCity(@PathVariable String city) {
        return service.findByCity(city);
    }

    @GetMapping(value = "/schedule", params = {"collectionDate"})
    @ResponseStatus(HttpStatus.OK)
    public List<Annotation> findBySchedule(@RequestParam("collectionDate") LocalDate collectionDate) {
        return service.findByDate(collectionDate);
    }

    @GetMapping("/schedule/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Annotation findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/schedule/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.delete(id);
        ResponseEntity.ok("Agendamento deletado com sucesso!");
    }

    @PutMapping("/schedule/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Annotation> update(@PathVariable Long id, @RequestBody @Valid AnnotationRegisterDto annotationRegisterDto){
        return ResponseEntity.ok(service.update(id, annotationRegisterDto));
    }

}
