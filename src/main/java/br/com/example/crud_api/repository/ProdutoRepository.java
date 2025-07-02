package br.com.example.crud_api.repository;

import br.com.example.crud_api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Anotação que marca a interface como um componente de repositório do Spring
public interface ProdutoRepository extends JpaRepository<Produto, Long> { // Herda os métodos CRUD básicos (save, findById, findAll, deleteById, etc.) para a entidade Produto, cuja chave primária é do tipo Long
}