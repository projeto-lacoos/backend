package br.com.lacoos.api.request;

import br.com.lacoos.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagamentoRequest {

    @NotNull
    private float musica;

    @NotNull
    private float cerimonia;

    @NotNull
    private float comida;

    @NotNull
    private float fotografia;

    @NotNull
    private float cabeloMaquiagem;

    @NotNull
    private float decoracao;

    @NotNull
    private float local;

    @NotNull
    private float totalP;
}