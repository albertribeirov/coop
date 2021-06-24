package br.com.cooperativa.util;

public class Mes {

	private Integer id;
	private String nome;
	
	public static final Mes[] MESES;
	
	static {
		MESES = new Mes[12];
		MESES[0] = new Mes(1, "Janeiro");
		MESES[1] = new Mes(2, "Fevereiro");
		MESES[2] = new Mes(3, "Março");
		MESES[3] = new Mes(4, "Abril");
		MESES[4] = new Mes(5, "Maio");
		MESES[5] = new Mes(6, "Junho");
		MESES[6] = new Mes(7, "Julho");
		MESES[7] = new Mes(8, "Agosto");
		MESES[8] = new Mes(9, "Setembro");
		MESES[9] = new Mes(10, "Outubro");
		MESES[10] = new Mes(11, "Novembro");
		MESES[11] = new Mes(12, "Dezembro");
	}

	public Mes(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}