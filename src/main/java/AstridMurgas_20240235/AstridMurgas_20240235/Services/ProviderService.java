package AstridMurgas_20240235.AstridMurgas_20240235.Services;

import AstridMurgas_20240235.AstridMurgas_20240235.Entities.ProviderEntity;
import AstridMurgas_20240235.AstridMurgas_20240235.Models.DTO.ProviderDTO;
import AstridMurgas_20240235.AstridMurgas_20240235.Repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository repo;

    public List<ProviderDTO> getAllProviders() {
        List<ProviderEntity> providers = repo.findAll();
        return providers.stream()
                .map(this::convertirAProviderDTO)
                .collect(Collectors.toList());
    }

    private ProviderDTO convertirAProviderDTO(ProviderEntity provider) {
        ProviderDTO dto = new ProviderDTO();
        dto.setProviderID(provider.getId());
        dto.setProviderName(provider.getName());
        dto.setProviderPhone(provider.getPhone());
        dto.setProviderAddress(provider.getAddress());
        dto.setProviderEmail(provider.getEmail());
        dto.setProviderCode(provider.getCode());
        dto.setProviderStatus(provider.getStatus());
        dto.setProviderComments(provider.getComments());
        return dto;
    }
}
