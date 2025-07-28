package AstridMurgas_20240235.AstridMurgas_20240235.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProviderController {
    @Autowired
    private ProviderService acceso;
}
