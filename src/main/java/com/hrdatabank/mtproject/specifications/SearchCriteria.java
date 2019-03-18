package com.hrdatabank.mtproject.specifications;

public class SearchCriteria<T> {
	public SearchCriteria(T key, String operation, T value) {
		super();
		this.key = key;
		this.operation = operation;
		this.value = value;
	}
	private T key;
	private String operation;
	private T value;
	public T getKey() {
		return key;
	}
	public void setKey(T key) {
		this.key = key;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}
