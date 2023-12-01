package br.com.lacoos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "formulario")
public class FormModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String estilo;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal orcamento;

    @Column(nullable = false)
    private int tipoDeficiencia;

    @Column(length = 50, nullable = false)
    private String grauVisao;

    @Column(length = 10, nullable = false)
    private String sensivelALuz;

    @Column(length = 100, nullable = false)
    private String musicaEntretenimento;

    @Column(length = 100, nullable = false)
    private String restricoesAlimentares;

    @Column(nullable = false)
    private int informacoes;

    @Column(length = 3, nullable = false)
    private String cadeiraDeRodas;

    @Column(length = 3, nullable = false)
    private String pisoTatil;

    @Column(length = 3, nullable = false)
    private String cardapioBraille;

    @Column(length = 50, nullable = false)
    private String nomeParceiro;

    @Column(nullable = false)
    private LocalDate dataCerimonia;

    @Column(nullable = false)
    private LocalTime horarioCerimonia;

    @Column(length = 80, nullable = false)
    private String ondeMora;

    @Column(length = 100, nullable = false)
    private String preferencias;

    @Column(length = 100, nullable = false)
    private String preferenciasDecoracao;

    @Column(length = 100, nullable = false)
    private String paletaDeCores;

    @Column(length = 3, nullable = false)
    private String indicacaoTatilDanca;

    @Column(length = 100, nullable = false)
    private String segurancaPista;

    @Column(length = 100, nullable = false)
    private String videoEFoto;

    @Column(length = 3, nullable = false)
    private String descricoesFotos;

    @Column(length = 100, nullable = false)
    private String assentos;

    @Column(length = 100, nullable = false)
    private String consideracoesAssentos;

    @Column(length = 100, nullable = false)
    private String adaptacaoProgramacao;

    @Column(length = 100, nullable = false)
    private String necessidades;

    @Column(length = 1000, nullable = false)
    private String maisInformacoes;

}