package com.example.ride.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ride.Entity.Question;
import com.example.ride.Entity.QuestionRepository;
import com.example.ride.Entity.QuizSessionRepository;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuizSessionRepository quizSessionRepository;

	@Override
	public void run(String... args) throws Exception {
		if (questionRepository.count() == 0) {
			Question q1 = new Question();
			q1.setQuestionText("What is the capital of France?");
			q1.setOptions(Arrays.asList("Paris", "London", "Berlin", "Madrid"));
			q1.setCorrectAnswer("Paris");

			Question q2 = new Question();
			q2.setQuestionText("What is 5 + 3?");
			q2.setOptions(Arrays.asList("5", "8", "10", "15"));
			q2.setCorrectAnswer("8");

			Question q3 = new Question();
			q3.setQuestionText("Which planet is known as the Red Planet?");
			q3.setOptions(Arrays.asList("Earth", "Mars", "Jupiter", "Saturn"));
			q3.setCorrectAnswer("Mars");

			Question q4 = new Question();
			q4.setQuestionText("Who wrote 'Hamlet'?");
			q4.setOptions(Arrays.asList("Charles Dickens", "J.K. Rowling", "William Shakespeare", "Leo Tolstoy"));
			q4.setCorrectAnswer("William Shakespeare");

			questionRepository.saveAll(Arrays.asList(q1, q2, q3, q4));
		}
	}
}
