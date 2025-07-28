package AstridMurgas_20240235.AstridMurgas_20240235.Controllers;

import AstridMurgas_20240235.AstridMurgas_20240235.Models.DTO.ProviderDTO;
import AstridMurgas_20240235.AstridMurgas_20240235.Services.ProviderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProviderController {
    @Autowired
    private ProviderService acceso;

    @GetMapping("/providers")
    public List<ProviderDTO> datosProviders() {
        return acceso.getAllProviders();
    }

    @PostMapping("/registarDatos")
    public ResponseEntity<?> nuevoProvider(@Valid @RequestBody ProviderDTO json, HttpServletRequest request) {
        try {
            ProviderDTO respuesta = acceso.insertarDatos(json);
            if (respuesta == null) {
                return ResponseEntity.badRequest().body(Map.of(
                        "status", "Inserción fallida",
                        "errorType", "VALIDATION_ERROR",
                        "message", "Los datos no pudieron ser registrados"
                ));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "Succes",
                    "data", respuesta
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "status", "Error",
                    "message", "Error no controlado al registrar usuario",
                    "detail", e.getMessage()
            ));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderDTO>actualizar(@PathVariable Long id, @RequestBody ProviderDTO dto){
        return acceso.actualizarProveedor(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>eliminar(@PathVariable Long id){
        if (acceso.eliminarProveedor(id)){
            return ResponseEntity.ok("Eliminado corectamente");
        }
        return ResponseEntity.status(404).body("no encontado");
    }
}
