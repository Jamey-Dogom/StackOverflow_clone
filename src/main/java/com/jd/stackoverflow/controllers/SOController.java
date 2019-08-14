package com.jd.stackoverflow.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jd.stackoverflow.models.Answer;
import com.jd.stackoverflow.models.Question;
import com.jd.stackoverflow.services.SOService;

@Controller
public class SOController {
	@Autowired
	private SOService sService;
	
	@RequestMapping("/questions/new")
	public String newQuestion() {
		return "new-question.jsp";
	}
	
	@PostMapping("/addQuestion")
	public String addQuestion(@RequestParam("question") String question, @RequestParam("tags") String tags) {
		Question q = new Question();
		q.setQuestion(question);
		sService.createQuestion(q);
		sService.tagMethod(q, tags);
		
		return "new-question.jsp";
	}
	
	@RequestMapping("/questions")
	public String dashBoard(Model model) {
		model.addAttribute("questions", sService.getAllQuestions());
		return "dashboard.jsp";
	}
	
	@RequestMapping("/questions/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model) {
		model.addAttribute("question", sService.findQuestionById(id));
		model.addAttribute("answers", sService.findAnswerQuestions(id));
		return "question.jsp";
	}
	
	@PostMapping("/addAnswer/{id}")
	public String addAnswer(@PathVariable("id") Long id, @RequestParam("answer") String answer) {
		Question q = sService.findQuestionById(id);
		List<Answer> lst = new ArrayList<>();
		Answer newAnswer = new Answer();
		newAnswer.setAnswer(answer);
		newAnswer.setQuestion(q);
		sService.createAnswer(newAnswer);
		lst.add(newAnswer);
		q.setAnswers(lst);
		sService.createQuestion(q);
		return "redirect:/questions/{id}";
	}
	

}
