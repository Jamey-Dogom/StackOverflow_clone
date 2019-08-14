package com.jd.stackoverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.stackoverflow.models.Answer;
import com.jd.stackoverflow.models.Question;
import com.jd.stackoverflow.models.Tag;
import com.jd.stackoverflow.repositories.AnswerRepository;
import com.jd.stackoverflow.repositories.QuestionRepository;
import com.jd.stackoverflow.repositories.TagRepository;

@Service
public class SOService {
	@Autowired
	private AnswerRepository aP;
	@Autowired
	private QuestionRepository qP;
	@Autowired
	private TagRepository tR;
	
	
	
	public void tagMethod(Question q, String tags) {
		String[] values = tags.split(",");
		List<Tag> lst = new ArrayList<>();
		for(int i = 0; i < values.length; i++) {
			Tag t = newTag(values[i]);
			lst.add(t);
		}
		q.setTags(lst);
		qP.save(q);
	}
	
	public Tag newTag(String s) {
		//if it doesn't exist in the DB 
		if(tR.findBySubjectContaining(s).size() == 0 || tR.findBySubjectContaining(s) == null) {
		Tag newTag = new Tag();
		newTag.setSubject(s);
		tR.save(newTag);
		return newTag;
}
		
		List <Tag> tags = tR.findBySubjectContaining(s);
				return tags.get(0);
	}

	public void createQuestion(Question q) {
		qP.save(q);
		
	}

	public List<Question> getAllQuestions() {
		return (List<Question>) qP.findAll();
	}

	public Question findQuestionById(Long id) {
		return qP.findById(id).get();
	}

	public List<Answer> findAnswerQuestions(Long id) {
		Optional<Question> question = qP.findById(id);
		return question.get().getAnswers();

	}

	public void createAnswer(Answer answer) {
		aP.save(answer);
		
	}

}
