package com.jd.stackoverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jd.stackoverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
