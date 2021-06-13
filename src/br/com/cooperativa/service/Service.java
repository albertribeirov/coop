package br.com.cooperativa.service;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Status;
import javax.transaction.UserTransaction;
import java.io.Serializable;

/**
 * Superclasse de todos os services da aplicação
 */
@RequestScoped
public abstract class Service implements Serializable {

	@Resource
	private UserTransaction ut;
	
	/*
	 * Inicia a transação
	 */
	protected void beginTransaction() {
		try {
			if (ut.getStatus() != Status.STATUS_ACTIVE) {
				ut.begin();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Faz o commit da transação
	 */
	protected void commitTransaction() {
		try {
			if (ut.getStatus() == Status.STATUS_ACTIVE) {
				ut.commit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Faz o rollback da transação
	 */
	protected void rollbackTransaction() {
		try {
			if (ut.getStatus() == Status.STATUS_ACTIVE) {
				ut.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}