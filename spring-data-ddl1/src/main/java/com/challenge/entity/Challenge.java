package com.challenge.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="challenge")
@EntityListeners(AuditingEntityListener.class)
public class Challenge implements Serializable {

	private static final long serialVersionUID = 8651415186970753362L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "name", columnDefinition = "VARCHAR(100)", nullable =false)
	private String name;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "slug", columnDefinition = "VARCHAR(50)")
	private String slug;

	@NotNull
	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@OneToMany(mappedBy = "primaryKey.challenge")
	private List<Submission> submissions;

	
	@OneToMany(mappedBy = "challenge")
	private List<Acceleration> accelerations;

}
