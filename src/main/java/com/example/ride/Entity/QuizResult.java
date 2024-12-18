package com.example.ride.Entity;

import lombok.Data;

@Data
public class QuizResult {
	private int totalQuestions;
	private int correctAnswers;
	private int incorrectAnswers;

	public QuizResult(int totalQuestions, int correctAnswers, int incorrectAnswers) {
		this.totalQuestions = totalQuestions;
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;
	}

}