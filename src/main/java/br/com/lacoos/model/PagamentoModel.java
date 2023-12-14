package br.com.lacoos.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pagamento_servicos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidos;

    @Column(name = "musica")
    private float musica;

    @Column(name = "cerimonia")
    private float cerimonia;

    @Column(name = "comida")
    private float comida;

    @Column(name = "fotografia")
    private float fotografia;

    @Column(name = "cabeloMaquiagem")
    private float cabeloMaquiagem;

    @Column(name = "decoracao")
    private float decoracao;

    @Column(name = "local")
    private float local;

    @Column(name = "totalPagamento")
    private float totalP;
}