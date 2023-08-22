/*
 * Board.java 2023. 08. 23
 *
 * Copyright 2023 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.charming.board.entity;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "board_id")
	private long id;

	@Column()
	private String title;

	@Lob()
	private String content;

	@Column(name = "created_date")
	@CreatedDate
	private LocalDateTime createdDate;

	public void update(Optional<String> title, Optional<String> content) {
		this.title = title.orElse(this.title);
		this.content = content.orElse(this.content);
	}
	@Builder
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
