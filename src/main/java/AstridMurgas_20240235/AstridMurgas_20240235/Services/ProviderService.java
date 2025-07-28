package AstridMurgas_20240235.AstridMurgas_20240235.Services;

import AstridMurgas_20240235.AstridMurgas_20240235.Entities.ProviderEntity;
import AstridMurgas_20240235.AstridMurgas_20240235.Exceptions.ExceptionProveedorNoRegistrado;
import AstridMurgas_20240235.AstridMurgas_20240235.Models.DTO.ProviderDTO;
import AstridMurgas_20240235.AstridMurgas_20240235.Repositories.ProviderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProviderService {
    @Autowired
    private ProviderRepository repo;

    //Metodo para obtener todos los proveedores
    public List<ProviderDTO> getAllProviders() {
        List<ProviderEntity> providers = repo.findAll();
        return providers.stream()
                .map(this::convertirAProviderDTO)
                .collect(Collectors.toList());
    }

    //Metodo para convertir Datos a tipo DTO
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

    //Metodo para insertar Proveedores
    public ProviderDTO insertarDatos(@Valid ProviderDTO json) {
        if (json == null || json.getProviderName() == null || json.getProviderName().isEmpty()){
            throw new IllegalArgumentException("El nombre del proveedor no debe ser nulo");
        }
        try{
            ProviderEntity entity = ConvertirAEntity(json);
            ProviderEntity respuesta = repo.save(entity);
            return convertirAProviderDTO(respuesta);
        }catch (Exception e){
            log.error("Error al registrar el proveedor: " + e.getMessage());
            throw new ExceptionProveedorNoRegistrado("Error al registrar Proveedor");
        }
    }

    private ProviderEntity ConvertirAEntity(@Valid ProviderDTO json) {
        ProviderEntity entity = new ProviderEntity();
        entity.setName(json.getProviderName());
        entity.setPhone(json.getProviderPhone());
        entity.setAddress(json.getProviderAddress());
        entity.setEmail(json.getProviderEmail());
        entity.setCode(json.getProviderCode());
        entity.setStatus(json.getProviderStatus());
        entity.setComments(json.getProviderComments());
        return entity;
    }
}
