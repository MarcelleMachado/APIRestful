package org.serratec.backend.library.repository;

import org.serratec.backend.library.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
