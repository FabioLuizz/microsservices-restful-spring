package br.com.fiap.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_SCHEDULE")
public class Annotation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_COLLECT")
    @SequenceGenerator(name = "SQ_COLLECT", sequenceName = "SQ_COLLECT", allocationSize = 1)
    private Long id;

    @Column(name = "NM_CITY", nullable = false)
    private String city;

    @Column(name = "NM_ADDRESS", nullable = false)
    private String address;

    @Column(name = "DS_COLLECTION_DATE", nullable = false)
    private LocalDate collectionDate;

    @Column(name = "DS_TRASH_TYPE", nullable = false)
    private String trashType;

    @Column(name = "ST_STATUS", nullable = false)
    private String status;

}
