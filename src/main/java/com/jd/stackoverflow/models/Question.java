package com.jd.stackoverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 1)
	private String question;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	// One to One relationship with answers
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	private List<Answer> answers;
	// @ManyToMany: Defines a many-valued association with many-to-many
	// multiplicity.
	// You will have to use this annotation on both entities.
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tags_questions", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;

	public Question() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	

}
