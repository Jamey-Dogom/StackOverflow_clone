package com.jd.stackoverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jd.stackoverflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

}
