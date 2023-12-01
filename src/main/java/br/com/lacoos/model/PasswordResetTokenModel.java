package br.com.lacoos.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "senha_resetar_token")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetTokenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Long token_id;

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = UserModel.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private UserModel user;

    @Column(name = "expirar_data")
    private LocalDateTime expiryDate;

    @Column(name = "token_usado", columnDefinition = "boolean default false")
    private Boolean usedToken;

}