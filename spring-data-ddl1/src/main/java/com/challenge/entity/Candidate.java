package com.challenge.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name="candidate")
@EntityListeners(AuditingEntityListener.class)
public class Candidate implements Serializable {

	private static final long serialVersionUID = 2428144737019635309L;

	@EmbeddedId
	private CandidatePK primaryKey;

	@NotNull
	@Column(name="status", columnDefinition ="INTEGER", nullable = false)
	private int status;
	
	@NotNull
	@CreatedDate
	@Column(name="created_at", updatable = false, nullable = false)
	private Date createdAt;
}
