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
    private Long id;

    @Column(length = 255, nullable = false)
    private String estilo;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal orcamento;

    @Column(nullable = false)
    private String tipoDeficiencia;

    @Column(length = 255, nullable = false)
    private String grauVisao;

    @Column(length = 255, nullable = false)
    private String sensivelALuz;

    @Column(length = 255, nullable = false)
    private String musicaEntretenimento;

    @Column(length = 255, nullable = false)
    private String restricoesAlimentares;

    @Column(nullable = false)
    private String informacoes;

    @Column(length = 255, nullable = false)
    private String cadeiraDeRodas;

    @Column(length = 255, nullable = false)
    private String pisoTatil;

    @Column(length = 255, nullable = false)
    private String cardapioBraille;

    @Column(length = 255, nullable = false)
    private String nomeParceiro;

    @Column(nullable = false)
    private LocalDate dataCerimonia;

    @Column(nullable = false)
    private LocalTime horarioCerimonia;

    @Column(length = 255, nullable = false)
    private String ondeMora;

    @Column(length = 255, nullable = false)
    private String preferencias;

    @Column(length = 255, nullable = false)
    private String preferenciasDecoracao;

    @Column(length = 255, nullable = false)
    private String paletaDeCores;

    @Column(length = 255, nullable = false)
    private String indicacaoTatilDanca;

    @Column(length = 255, nullable = false)
    private String segurancaPista;

    @Column(length = 255, nullable = false)
    private String videoEFoto;

    @Column(length = 255, nullable = false)
    private String descricoesFotos;

    @Column(length = 255, nullable = false)
    private String assentos;

    @Column(length = 255, nullable = false)
    private String consideracoesAssentos;

    @Column(length = 255, nullable = false)
    private String adaptacaoProgramacao;

    @Column(length = 255, nullable = false)
    private String necessidades;

    @Column(length = 1000, nullable = false)
    private String maisInformacoes;

}