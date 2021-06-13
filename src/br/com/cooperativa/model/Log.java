package br.com.cooperativa.model;

import br.com.cooperativa.TipoMensagem;
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
	 * Texto da mensagem
	 */
	@Column(name = "mensagem", nullable = false, length = 100)
	private String mensagem;
	
	/**
	 * Tipo da mensagem de log 
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_mensagem" ,nullable = false, length = 20)
	private TipoMensagem tipoMensagem;

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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getTipoMensagem() {
		return tipoMensagem.name();
	}

	public void setTipoMensagem(TipoMensagem tipoMensagem) {
		this.tipoMensagem = tipoMensagem;
	}

}
