/*
 * BoardListResult.java 2023. 08. 23
 *
 * Copyright 2023 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.charming.board.model;

import java.util.List;

import com.charming.board.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**

 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardListResult {
	private List<Board> boards;
	private int totalPage;
	private int totalCount;
}
