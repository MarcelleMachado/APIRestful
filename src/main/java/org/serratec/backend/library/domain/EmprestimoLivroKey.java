package org.serratec.backend.library.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmprestimoLivroKey implements Serializable{
		@Column(name="id_livro")
		Long livroId;
		@Column(name="id_emprestimo")
		Long emprestimoId;
		public Long getLivroId() {
			return livroId;
		}
		public void setLivroId(Long livroId) {
			this.livroId = livroId;
		}
		public Long getEmprestimoId() {
			return emprestimoId;
		}
		public void setEmprestimoId(Long emprestimoId) {
			this.emprestimoId = emprestimoId;
		}
		@Override
		public int hashCode() {
			return Objects.hash(emprestimoId, livroId);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EmprestimoLivroKey other = (EmprestimoLivroKey) obj;
			return Objects.equals(emprestimoId, other.emprestimoId) && Objects.equals(livroId, other.livroId);
		}
		
		
}
