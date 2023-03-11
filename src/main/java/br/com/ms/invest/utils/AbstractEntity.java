package br.com.ms.invest.utils;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import br.com.ms.invest.modules.grupoUsuaria.GrupoUsuaria;
import br.com.ms.invest.modules.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy= GenerationType.UUID)
	protected String id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="grupoUsuariaId", nullable=false)
	protected GrupoUsuaria grupoUsuaria;
	

	@Column(nullable = false, columnDefinition="char(36)")
	private String criadopor;
	
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@CreatedDate
	@Column(nullable = false, columnDefinition="DATETIME default current_timestamp()")
	private LocalDateTime criadoem;

	
	@Column(nullable = false, columnDefinition="char(36)")
	private String modificadopor;
	
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@LastModifiedDate
	@Column(nullable = false, columnDefinition="DATETIME default current_timestamp()")
	private LocalDateTime modificadoem;
	
	@Column(columnDefinition="char(36)")
	private String excluidopor;
	
	
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime excluidoem;
	
	@PrePersist
    private void auditCreatedBy() {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			var ehUsuario = principal instanceof Usuario;
			if (ehUsuario) {
				String id = ((Usuario) principal).getId();
			 	criadopor = id;
			 	criadoem = LocalDateTime.now();
			 	modificadopor = id;
			 	modificadoem = LocalDateTime.now();
			 	grupoUsuaria = ((Usuario) principal).getGrupoUsuaria();
			 	return;
			} 
		} 
		criadoem = LocalDateTime.now();
		criadopor = "não identificado";
		modificadoem = LocalDateTime.now();
		modificadopor = "não identificado";
		
    }

	@PreUpdate
	private void auditModifiedBy() {
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			var ehUsuario = principal instanceof Usuario;
			if (ehUsuario) {
				
				String id = ((Usuario) principal).getId();
			
				if (excluidoem != null) {
					excluidopor = id;
					excluidoem = LocalDateTime.now();
				} else {
					modificadopor = id;
				}
				
				return;
			} 
		}
		if (excluidoem != null) {
			excluidopor = "não identificado";
			excluidoem = LocalDateTime.now();
		} else {
			modificadopor = "não identificado";
			modificadoem = LocalDateTime.now();
		}
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public GrupoUsuaria getGrupoUsuaria() {
		return grupoUsuaria;
	}

	public void setGrupoUsuaria(GrupoUsuaria grupoUsuaria) {
		this.grupoUsuaria = grupoUsuaria;
	}
	
	public String getCriadopor() {
		return criadopor;
	}

	public void setCriadopor(String criadopor) {
		this.criadopor = criadopor;
	}

	public LocalDateTime getCriadoem() {
		return criadoem;
	}
	
	public void setCriadoem(LocalDateTime criadoem) {
		this.criadoem = criadoem;
	}

	public String getModificadopor() {
		return modificadopor;
	}

	public void setModificadopor(String modificadopor) {
		this.modificadopor = modificadopor;
	}

	public LocalDateTime getModificadoem() {
		return modificadoem;
	}

	public void setModificadoem(LocalDateTime modificadoem) {
		this.modificadoem = modificadoem;
	}

	public String getExcluidopor() {
		return excluidopor;
	}

	public void setExcluidopor(String excluidopor) {
		this.excluidopor = excluidopor;
	}

	public LocalDateTime getExcluidoem() {
		return excluidoem;
	}

	public void setExcluidoem(LocalDateTime excluidoem) {
		this.excluidoem = excluidoem;
	}


	
}
