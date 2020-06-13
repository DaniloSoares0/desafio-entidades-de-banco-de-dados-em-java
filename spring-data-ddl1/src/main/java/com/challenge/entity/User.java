package com.challenge.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

	private static final long serialVersionUID = -6302568448710051974L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@NotNull
    @Size(min = 1, max = 100)
	@Column(name = "full_name",columnDefinition = "VARCHAR(100)",nullable = false)
	private String fullName;
	
	@NotNull
    @Email
    @Size(min = 1, max = 100)
	@Column(name = "email",columnDefinition = "VARCHAR(100)")
	private String email;
	
	@NotNull
    @Size(min = 1, max = 50)
	@Column(name = "nickname",columnDefinition = "VARCHAR(50)")
	private String nickname;
	
	@NotNull
    @Size(min = 1, max = 255)
	@Column(name = "password",columnDefinition = "VARCHAR(255)", nullable = false)
	private String password;
	
    @NotNull
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
    @OneToMany(mappedBy = "primaryKey.user")
    private List<Submission> submissions;
	
    
    @OneToMany(mappedBy = "primaryKey.user")
    private List<Candidate> candidates;
}
