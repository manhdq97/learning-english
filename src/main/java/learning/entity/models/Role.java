package learning.entity.models;

import learning.common.RoleEnum;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "roles")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @NonNull
    private RoleEnum name;

//    // 1 role có chứa nhiều users thông qua quan hệ của bảng user với bảng role thể hiện qua ánh xạ ngược mappedBy của User::class
//    @OneToMany(mappedBy = "role")
//    private Set<User> users = new HashSet<>();
}
