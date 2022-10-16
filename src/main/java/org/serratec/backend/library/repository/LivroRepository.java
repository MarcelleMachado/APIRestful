package org.serratec.backend.library.repository;
import org.serratec.backend.library.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	Livro findByIsbn(String isbn);
//	@Query("SELECT titulo, categoria FROM livros ORDER BY categoria desc")
	
	
}
