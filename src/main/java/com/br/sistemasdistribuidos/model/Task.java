package com.br.sistemasdistribuidos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Task {
	
	@JsonIgnore
	@JsonDeserialize
	private long id;
	private String name;
	private long list_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getList_id() {
		return list_id;
	}
	public void setList_id(long list_id) {
		this.list_id = list_id;
	}

}
