package sn.hubschool.users.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;



@Entity

@Data @NoArgsConstructor @AllArgsConstructor
public final class Authoritie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;
}
