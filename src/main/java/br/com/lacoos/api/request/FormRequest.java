package br.com.lacoos.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FormRequest {

    @NotBlank
    private String estilo;

    @DecimalMin(value = "0", inclusive = false)
    private BigDecimal orcamento;

    @NotBlank
    private String tipoDeficiencia;

    @NotBlank
    private String grauVisao;

    @NotBlank
    private String sensivelALuz;

    @NotBlank
    private String musicaEntretenimento;

    @NotBlank
    private String restricoesAlimentares;

    @NotBlank
    private String informacoes;

    @NotBlank
    private String cadeiraDeRodas;

    @NotBlank
    private String pisoTatil;

    @NotBlank
    private String cardapioBraille;

    @NotBlank
    private String nomeParceiro;

    @NotNull
    private String dataCerimonia;

    @NotNull
    private String horarioCerimonia;

    @NotBlank
    private String ondeMora;

    @NotBlank
    private String preferencias;

    @NotBlank
    private String preferenciasDecoracao;

    @NotBlank
    private String paletaDeCores;

    @NotBlank
    private String indicacaoTatilDanca;

    @NotBlank
    private String segurancaPista;

    @NotBlank
    private String videoEFoto;

    @NotBlank
    private String descricoesFotos;

    @NotBlank
    private String assentos;

    @NotBlank
    private String consideracoesAssentos;

    @NotBlank
    private String adaptacaoProgramacao;

    @NotBlank
    private String necessidades;

    @NotBlank
    private String maisInformacoes;

}