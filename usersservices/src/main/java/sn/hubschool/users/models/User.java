package sn.hubschool.users.models;



import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class User  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Email
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private boolean enabled;
    private Date lastLoginTime;

  //  @Transient
  //  private String newPassword;

  //  @Transient
  //  private String confirmPassword;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Authoritie> authorities;
    @Enumerated(EnumType.STRING)
    private Language language;
}
