package com.example.ride.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ride.Entity.AnswerResponse;
import com.example.ride.Entity.Question;
import com.example.ride.Entity.QuizResult;
import com.example.ride.Entity.QuizSession;
import com.example.ride.Services.QuizService;

@RestController
@RequestMapping("/quiz")
class QuizController {

	@Autowired
	private QuizService quizService;

	@PostMapping("/start")
	public QuizSession startNewSession() {
		return quizService.startNewSession();
	}

	@GetMapping("/question")
	public Question getRandomQuestion(@RequestParam UUID sessionId) {
		return quizService.getRandomQuestion(sessionId);
	}

	@PostMapping("/submit")
	public AnswerResponse submitAnswer(@RequestParam UUID sessionId, @RequestParam Long questionId,
			@RequestParam String answer) {
		return quizService.submitAnswer(sessionId, questionId, answer);
	}

	@GetMapping("/results")
	public QuizResult getResults(@RequestParam UUID sessionId) {
		return quizService.getResults(sessionId);
	}
}