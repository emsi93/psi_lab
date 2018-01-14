package com.project.psi.db.entity;

import java.time.LocalDateTime;

public class History {

	private LocalDateTime data;
	private String description;

	public History(LocalDateTime data, String description) {
		super();
		this.data = data;
		this.description = description;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}