package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CandidatePK implements Serializable {

	private static final long serialVersionUID = -8679429283932418457L;

	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "acelleration_id", nullable = false)
	private Acceleration acceleration;
	
	@ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
	private Company company;

}
