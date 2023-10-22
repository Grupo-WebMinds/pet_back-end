package webminds.group.pet_backend.domain.arquivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webminds.group.pet_backend.domain.arquivo.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {
}
