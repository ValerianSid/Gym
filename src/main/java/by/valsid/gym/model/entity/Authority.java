package by.valsid.gym.model.entity;

import by.valsid.gym.model.enums.Roles;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class Authority implements GrantedAuthority {

    private static final String SEQ_NAME = "authority_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Roles authority;

    @ManyToOne
    @JoinColumn(name = "gym_user_id")
    private GymUser gymUser;

    @Override
    @Transient
    public String getAuthority() {
        return authority.name();
    }
}
