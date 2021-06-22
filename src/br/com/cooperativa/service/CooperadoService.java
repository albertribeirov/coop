package br.com.cooperativa.service;

import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.dao.CooperadoDAO;
import br.com.cooperativa.dao.EnderecoDAO;
import br.com.cooperativa.ejb.ControladorCooperado;
import br.com.cooperativa.exception.ValidationException;
import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.util.Constantes;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.List;

public class CooperadoService extends Service {

    @EJB
    private ControladorCooperado controladorCooperado;

    @Inject
    private CooperadoDAO cooperadoDAO;

    @Inject
    private EnderecoDAO enderecoDAO;

    @Inject
    private LogService logService;

    public Cooperado findById(Integer id) {
        return cooperadoDAO.findById(Cooperado.class, id);
    }

    public void inserir(Cooperado cooperado) throws ValidationException {
        try {
            beginTransaction();

            validarExisteCooperadoAndEndereco(cooperado);

            controladorCooperado.inserirCooperado(cooperado);
            logService.log("Endereço inserido: " + cooperado.getEndereco().getRuaComNumero(), TipoMensagem.INFO);
            logService.log("Cooperado inserido: " + cooperado.getNomeCompleto(), TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException exception) {
            rollbackTransaction();
            throw exception;
        }
    }

    public void atualizar(Cooperado cooperado) throws ValidationException {
        try {
            beginTransaction();

            validarExisteCooperadoAndEndereco(cooperado);

            controladorCooperado.alterarCooperado(cooperado);
            logService.log("Endereço alterado: " + cooperado.getEndereco().getRuaComNumero(), TipoMensagem.INFO);
            logService.log("Cooperado alterado: " + cooperado.getNomeCompleto(), TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException exception) {
            rollbackTransaction();
            throw exception;
        }
    }

    private void validarExisteCooperadoAndEndereco(Cooperado cooperado) throws ValidationException {
        if (cooperadoDAO.existeCooperadoComNome(cooperado.getNomeCompleto())) {
            throw new ValidationException(Constantes.MSG_ERRO_EXISTE_COOPERADO_NOME);
        }

        if (cooperadoDAO.existeCooperadoComCpf(cooperado.getCpf())) {
            throw new ValidationException(Constantes.MSG_ERRO_EXISTE_COOPERADO_CPF);
        }

        if (enderecoDAO.existeEnderecoComRuaAndNumero(cooperado.getEndereco().getRuaComNumero())) {
            throw new ValidationException("Existe endereço cadastrado com esta rua e número.");
        }
    }

    public void excluir(Integer id) {
        try {
            beginTransaction();

            Cooperado cooperado = cooperadoDAO.findById(Cooperado.class, id);
            cooperadoDAO.excluir(cooperado);
            logService.log("Cooperado excluído: " + id, TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException exception) {
            rollbackTransaction();
            throw exception;
        }
    }

    public List<Cooperado> listarCooperados() {
        return cooperadoDAO.listarCooperados();
    }
}
