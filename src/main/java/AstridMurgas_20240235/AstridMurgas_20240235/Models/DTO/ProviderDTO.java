package AstridMurgas_20240235.AstridMurgas_20240235.Models.DTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @EqualsAndHashCode
@Getter @Setter
public class ProviderDTO {
    //Atributos
    @Id
    private Long providerID;

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    private String providerName;

    private String providerPhone;
    private String providerAddress;

    @Email(message = "Debe ser un correo valido")
    private String providerEmail;

    private String providerCode;
    private Number providerStatus;
    private String providerComments;
}
