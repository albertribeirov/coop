package br.com.cooperativa.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Log {

	public enum TipoMensagem {
		INFO, ERRO
	}

	/**
	 * ID da mensagem
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Data da mensagem
	 */
	@Column(name = "data", nullable = false, updatable = false)
	@CreationTimestamp
	private LocalDateTime data;
	
	/**
	 * Tipo da mensagem de log 
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_mensagem" ,nullable = false)
	private TipoMensagem tipo;

	/**
	 * Texto da mensagem
	 */
	@Column(name = "mensagem", nullable = false)
	private String mensagem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public TipoMensagem getTipo() {
		return tipo;
	}

	public void setTipo(TipoMensagem tipo) {
		this.tipo = tipo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
