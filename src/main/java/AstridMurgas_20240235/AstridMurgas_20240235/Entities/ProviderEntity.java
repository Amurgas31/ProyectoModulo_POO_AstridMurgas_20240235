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
    @Column(name = "providerID")
    private Long Id;

    @Column(name = "providerName", unique = true)
    private String Name;

    @Column(name = "providerPhone")
    private String Phone;

    @Column(name = "providerAddress")
    private String Address;

    @Column(name = "providerEmail")
    private String Email;

    @Column(name = "providerCode", unique = true)
    private String Code;

    @Column(name = "providerStatus")
    private Number Status;

    @Column(name = "providerComments")
    private String Comments;
}
