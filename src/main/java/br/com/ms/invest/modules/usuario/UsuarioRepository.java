package br.com.ms.invest.modules.usuario;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	@Query("SELECT u FROM Usuario u WHERE u.username = :username")
	Usuario findByUsername(@Param("username") String username);
}
