package br.com.ms.invest.modules.ativo;

import static br.com.ms.invest.common.InvestConstants.ATIVO;
import static br.com.ms.invest.common.InvestConstants.ATIVOINVALIDO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class AtivoRepositoryTest {

	@Autowired
	private AtivoRepository ativoRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;

	@AfterEach
	public void limpaId() {
		ATIVO.setId(null);
	}
	
	
	@Test	
	public void createAtivo_WithValidData_ReturnsAtivo() {
		Ativo obj = ATIVO;
		Ativo ativo = ativoRepository.save(obj);
		
		Ativo sut = testEntityManager.find(Ativo.class, ativo.getId());

	    assertThat(sut).isNotNull();
	    assertThat(sut.getCodigo()).isEqualTo(ATIVO.getCodigo());
	}	
	
	@Test	
	public void createAtivo_WithInvalidData_ThrowsException() {
		
		Ativo emptyAtivo = new Ativo();
		
		assertThatThrownBy( () -> ativoRepository.save(emptyAtivo)).isInstanceOf(RuntimeException.class) ;
		assertThatThrownBy( () -> ativoRepository.save(ATIVOINVALIDO)).isInstanceOf(RuntimeException.class) ;
		
	}	

		
	
	public void createAtivo_WithExistingCodigo_ThrowsException() {
		Ativo obj = ATIVO;
		ativoRepository.save(obj);
		
		assertThatThrownBy( () -> ativoRepository.save(obj)).isInstanceOf(RuntimeException.class) ;
		
	}	
	
	public void getAtivo_ByExistingId_ReturnsAtivo() {
		
	}
	
	public void getAtivo_ByUnexistingId_ReturnsEmpty() {
		
	}
	
	public void getAtivo_ByExistingCodigo_ReturnsAtivo() {
		
	}
	
	public void getAtivo_ByUnexistingCodigo_ReturnsNotFound() {
		
	}
	
	public void listAtivos_ReturnsFilteredAtivos() {
		
	}
	
	public void listAtivos_ReturnsNoAtivos() {
		
	}
	
	public void removeAtivo_WithExistingId_RemovesAtivoFromDatabase() {
		
	}
	
	public void removeAtivo_WithUnexistingId_ThrowsException() {
		
	}
	
	
	
}
