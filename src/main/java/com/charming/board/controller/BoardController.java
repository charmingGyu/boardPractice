/*
 * BoardController.java 2023. 08. 23
 *
 * Copyright 2023 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.charming.board.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charming.board.entity.Board;
import com.charming.board.exception.ErrorCode;
import com.charming.board.exception.ServiceException;
import com.charming.board.model.BoardDto;
import com.charming.board.model.BoardListResult;
import com.charming.board.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	private BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ResponseEntity<BoardListResult> getBoardListResult(@RequestParam(required = false, defaultValue = "0") int offset, @RequestParam(required = false, defaultValue = "10") int size) {
		Page<Board> boardPage = boardService.findAll(offset, size);

		BoardListResult boardListResult = BoardListResult.builder()
			.boards(boardPage.toList())
			.totalPage(boardPage.getTotalPages())
			.totalCount((int)boardPage.getTotalElements())
			.build();

		return ResponseEntity.ok(boardListResult);
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ResponseEntity<Board> getBoardById(@PathVariable long id) throws ServiceException {
		return ResponseEntity.ok(boardService.findBoardById(id).orElseThrow(() -> new ServiceException(ErrorCode.POST_NOT_FOUND)));
	}

	@PostMapping("/post")
	public ResponseEntity<Board> postBoard(@RequestBody BoardDto board) throws ServiceException {
		return ResponseEntity.ok(boardService.save(board.getTitle(), board.getContent()));
	}

	@PatchMapping("/post/{id}")
	public ResponseEntity<Board> updateBoard(@PathVariable long id, @RequestBody BoardDto board) throws ServiceException {
		return ResponseEntity.ok(boardService.update(id, board.getTitle(), board.getContent()));
	}

	@DeleteMapping("/post/{id}")
	public void deleteBoard(@PathVariable long id) throws ServiceException {
		boardService.delete(id);
	}

}
