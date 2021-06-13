package br.com.cooperativa.service;

import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.dao.CooperadoDAO;
import br.com.cooperativa.exception.ValidationException;
import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.model.Log;
import br.com.cooperativa.util.Constantes;

import javax.inject.Inject;
import java.util.List;

public class CooperadoService extends Service {

    @Inject
    private CooperadoDAO cooperadoDAO;

    @Inject
    private LogService logService;

    /**
     * Carrega um cooperado cadastrado no banco de dados.
     *
     * @param id  Id do condom�nio que ser� buscado no banco
     */
    public Cooperado findById(Integer id) {
        return cooperadoDAO.findById(Cooperado.class, id);
    }

    /**
     * Insere um novo Cooperado no banco de dados
     *
     * @param cooperado Cooperado a ser inserido
     * @throws ValidationException Exce��o de valida��o
     */
    public void inserir(Cooperado cooperado) throws ValidationException {
        try {
            beginTransaction();

            if (cooperadoDAO.existeCooperadoComNome(cooperado.getNomeCompleto())) {
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_COOPERADO_NOME);
            }

            if (cooperadoDAO.existeCooperadoComCpf(cooperado.getCpf())) {
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_COOPERADO_CPF);
            }

            cooperadoDAO.salvar(cooperado);
            logService.log("Cooperado inserido: " + cooperado.getNomeCompleto(), TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

    /**
     * Alter um Cooperado cadastrado no banco de dados.
     *
     * @param cooperado Cooperado que ser� alterado
     * @throws ValidationException Exce��o de valida��o
     */
    public void atualizar(Cooperado cooperado) throws ValidationException {
        try {
            beginTransaction();

            if(cooperadoDAO.existeCooperadoComNome(cooperado.getNomeCompleto())) {
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_COOPERADO_NOME);
            }

            if (cooperadoDAO.existeCooperadoComCpf(cooperado.getCpf())) {
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_COOPERADO_CPF);
            }

            cooperadoDAO.alterar(cooperado);
            logService.log("Cooperado alterado: " + cooperado.getId(), TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

    /**
     * Exclui um Cooperado do banco de dados
     *
     * @param id N�mero de matr�cula do Cooperado a ser exclu�do
     */
    public void excluir(Integer id) {
        try {
            beginTransaction();

            Cooperado cooperado = cooperadoDAO.findById(Cooperado.class, id);
            cooperadoDAO.excluir(cooperado);
            logService.log("Cooperado exclu�do: " + id, TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

    /**
     * L� todos os Apartamentos cadastrados no banco de dados
     *
     * @return Lista de Condom�nios cadastrados
     */
    public List<Cooperado> listarCooperados() {
        return cooperadoDAO.listarCooperados();
    }
}
