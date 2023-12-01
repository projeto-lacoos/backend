package br.com.lacoos.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "password_reset_token")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id")
    private Long token_id;

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = UserModel.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "id")
    private UserModel user;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Column(name = "used_token", columnDefinition = "boolean default false")
    private Boolean usedToken;

}