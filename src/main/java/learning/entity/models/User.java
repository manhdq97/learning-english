package learning.entity.models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;

    @NonNull
    @Column(nullable = false, length = 20)
    private String username;

    @NonNull
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String password;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    // quan hệ 1 role nhiều user được thể hiện qua joinColumn role.id
    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
}
