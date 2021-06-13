package br.com.cooperativa;

public enum TipoMensagem {
    INFO(1), ERRO(2);

    private int valor;

    TipoMensagem(int valor) {
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }
}
