package br.com.cooperativa.service;

import javax.annotation.Resource;
import javax.transaction.Status;
import javax.transaction.UserTransaction;
import java.io.Serializable;

public abstract class Service implements Serializable {

	@Resource
	private UserTransaction ut;
	
	protected void beginTransaction() {
		try {
			if (ut.getStatus() != Status.STATUS_ACTIVE) {
				ut.begin();
			}
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	protected void commitTransaction() {
		try {
			if (ut.getStatus() == Status.STATUS_ACTIVE) {
				ut.commit();
			}
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
	
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