package com.example.ride.Entity;

import lombok.Data;

@Data
public class AnswerResponse {
	private boolean correct;

	public AnswerResponse(boolean correct) {
		this.correct = correct;
	}

	public boolean isCorrect() {
		return correct;
	}
}