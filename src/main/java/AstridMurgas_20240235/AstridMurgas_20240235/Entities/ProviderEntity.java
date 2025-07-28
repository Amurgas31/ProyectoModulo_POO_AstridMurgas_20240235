package AstridMurgas_20240235.AstridMurgas_20240235.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "TBPROVIDER")
@Getter @Setter @ToString @EqualsAndHashCode
public class ProviderEntity {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_provider")
    @SequenceGenerator(name = "seq_provider", sequenceName = "seq_provider", allocationSize = 1)
    @Column(name = "PROVIDERID")
    private Long Id;

    @Column(name = "PROVIDERNAME", unique = true)
    private String Name;

    @Column(name = "PROVIDERPHONE")
    private String Phone;

    @Column(name = "PROVIDERADDRESS")
    private String Address;

    @Column(name = "PROVIDEREMAIL")
    private String Email;

    @Column(name = "PROVIDERCODE", unique = true)
    private String Code;

    @Column(name = "PROVIDERSTATUS")
    private Number Status;

    @Column(name = "PROVIDERCOMMENTS")
    private String Comments;
}
