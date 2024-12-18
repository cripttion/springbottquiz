package com.example.ride.Services;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ride.Entity.AnswerResponse;
import com.example.ride.Entity.Question;
import com.example.ride.Entity.QuestionRepository;
import com.example.ride.Entity.QuizResult;
import com.example.ride.Entity.QuizSession;
import com.example.ride.Entity.QuizSessionRepository;

@Service
public class QuizService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuizSessionRepository quizSessionRepository;

	public QuizSession startNewSession() {
		QuizSession session = QuizSession.builder().id(UUID.randomUUID()).correctAnswers(0).totalQuestions(0).build();
		quizSessionRepository.save(session);
		return session;
	}

	public Question getRandomQuestion(UUID sessionId) {
		QuizSession session = quizSessionRepository.findById(sessionId)
				.orElseThrow(() -> new RuntimeException("Session not found"));
		List<Question> questions = questionRepository.findAll();
		if (questions.isEmpty())
			throw new RuntimeException("No questions available");
		return questions.get(new Random().nextInt(questions.size()));
	}

	public AnswerResponse submitAnswer(UUID sessionId, Long questionId, String answer) {
		QuizSession session = quizSessionRepository.findById(sessionId)
				.orElseThrow(() -> new RuntimeException("Session not found"));
		Question question = questionRepository.findById(questionId)
				.orElseThrow(() -> new RuntimeException("Question not found"));

		session.setTotalQuestions(session.getTotalQuestions() + 1);
		boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(answer);
		if (isCorrect) {
			session.setCorrectAnswers(session.getCorrectAnswers() + 1);
		}
		quizSessionRepository.save(session);
		return new AnswerResponse(isCorrect);
	}

	public QuizResult getResults(UUID sessionId) {
		QuizSession session = quizSessionRepository.findById(sessionId)
				.orElseThrow(() -> new RuntimeException("Session not found"));
		return new QuizResult(session.getTotalQuestions(), session.getCorrectAnswers(),
				session.getTotalQuestions() - session.getCorrectAnswers());
	}
}
