package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "good_action")
public class GoodAction {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "action_time")
	private Long actionTime;

	@Column(name = "added_to_cart")
	private Boolean addedToCart;

	@ManyToOne(targetEntity = Account.class)
	private Account account;

	@ManyToOne(targetEntity = Good.class)
	private Good good;

}