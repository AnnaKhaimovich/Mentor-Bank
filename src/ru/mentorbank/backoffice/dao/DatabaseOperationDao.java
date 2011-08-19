package ru.mentorbank.backoffice.dao;

import java.util.HashSet;
import java.util.Set;

import ru.mentorbank.backoffice.dao.exception.OperationDaoException;
import ru.mentorbank.backoffice.model.Operation;

public class DatabaseOperationDao implements OperationDao {

	public Set<Operation> operations;

	public DatabaseOperationDao() {
		operations = new HashSet<Operation>();
	}

	@Override
	public void saveOperation(Operation operation) throws OperationDaoException {
		operations.add(operation);
	}

	@Override
	public Set<Operation> getOperations() throws OperationDaoException {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

}
