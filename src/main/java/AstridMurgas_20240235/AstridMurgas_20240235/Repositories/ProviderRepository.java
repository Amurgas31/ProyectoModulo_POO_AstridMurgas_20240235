package AstridMurgas_20240235.AstridMurgas_20240235.Repositories;

import AstridMurgas_20240235.AstridMurgas_20240235.Entities.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {

}
