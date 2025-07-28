package AstridMurgas_20240235.AstridMurgas_20240235.Controllers;

import AstridMurgas_20240235.AstridMurgas_20240235.Models.DTO.ProviderDTO;
import AstridMurgas_20240235.AstridMurgas_20240235.Services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProviderController {
    @Autowired
    private ProviderService acceso;

    @GetMapping("/providers")
    public List<ProviderDTO> datosProviders(){
        return acceso.getAllProviders();
    }
}
