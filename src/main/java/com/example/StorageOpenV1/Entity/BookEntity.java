package com.example.StorageOpenV1.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "Libros_TBL")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIBRO_ID")
    private  long idBook;

    @NotBlank
    @Column(name = "TITULO_lIBRO")
    private String titleBook;

    @NotBlank
    @Column(name = "AUTOR_LIBRO")
    private String authorBook;

    @NotNull
    @Column(name = "PAGINA_LIBRO")
    private Integer pagesBook;

    @NotBlank
    @Column(name = "URL_LIBRO")
    private String urlBook;

    @NotNull
    @Column(name = "PRECIO_LIBRO")
    private Double priceBook;
}
