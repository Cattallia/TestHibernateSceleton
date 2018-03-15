package org.itstep.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "goods")
public class Good implements Serializable {

	@Id
	@Column(name = "asin", length = 20)
	private String asin;

	@Column(name = "good_name", length = 300)
	private String name;

	@Column(name = "shop_url", length = 500)
	private String shopUrl;

	@Column(name = "price")
	private Integer price;

	public Good() {
	}

	public Good(String asin, String name, String shopUrl, int price) {
		this.asin = asin;
		this.name = name;
		this.shopUrl = shopUrl;
		this.price = price;
	}

}