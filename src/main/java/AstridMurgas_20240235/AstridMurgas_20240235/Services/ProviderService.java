package AstridMurgas_20240235.AstridMurgas_20240235.Services;

import AstridMurgas_20240235.AstridMurgas_20240235.Repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository repo;
}
