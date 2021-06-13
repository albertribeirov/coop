package br.com.cooperativa.service;

import br.com.cooperativa.dao.CooperadoDAO;
import br.com.cooperativa.exception.ValidationException;
import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.model.Log;
import br.com.cooperativa.util.Constantes;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

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
    public Cooperado carregar(Integer id) {
        return cooperadoDAO.carregar(Cooperado.class, id);
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
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_CLIENTE_NOME);
            }

            if (cooperadoDAO.existeCooperadoComCpf(cooperado.getCpf())) {
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_CLIENTE_EMAIL);
            }

            cooperadoDAO.salvar(cooperado);
            logService.log("Cooperado inserido: " + cooperado.getNomeCompleto(), Log.TipoMensagem.INFO);

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
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_CLIENTE_NOME);
            }

            if(Objects.nonNull(cooperadoDAO.buscarCooperadoPorCpf(cooperado.getCpf()))) {
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_CLIENTE_EMAIL);
            }

            cooperadoDAO.alterar(cooperado);
            logService.log("Cooperado alterado: " + cooperado.getId(), Log.TipoMensagem.INFO);

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

            Cooperado cooperado = cooperadoDAO.carregar(Cooperado.class, id);
            cooperadoDAO.excluir(cooperado);
            logService.log("Cooperado exclu�do: " + id, Log.TipoMensagem.INFO);

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
