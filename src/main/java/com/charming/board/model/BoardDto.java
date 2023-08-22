/*
 * BoardDto.java 2023. 08. 23
 *
 * Copyright 2023 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.charming.board.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**

 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
	private String title;
	private String content;
}
