package com.challenge.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name="company")
@EntityListeners(AuditingEntityListener.class)
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "name", columnDefinition = "VARCHAR(100)", nullable = false)
	private String name;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "slug", columnDefinition = "VARCHAR(50)", nullable = false)
	private String slug;

	@NotNull
	@CreatedDate
	@Column(name="created_at", updatable = false, nullable = false)
	private Date createdAt;

    @OneToMany(mappedBy = "primaryKey.company")
	private List<Candidate> candidate;
}
