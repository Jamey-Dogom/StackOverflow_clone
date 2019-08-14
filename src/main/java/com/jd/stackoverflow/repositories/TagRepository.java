package com.jd.stackoverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jd.stackoverflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findBySubjectContaining(String search);

}
