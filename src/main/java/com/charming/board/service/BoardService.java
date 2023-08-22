/*
 * BoardService.java 2023. 08. 23
 *
 * Copyright 2023 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.charming.board.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.charming.board.entity.Board;
import com.charming.board.exception.ErrorCode;
import com.charming.board.exception.ServiceException;
import com.charming.board.repository.BoardRepository;


/**

 */
@Service
public class BoardService {
	private BoardRepository boardRepository;

	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

	public Page<Board> findAll(int offset, int size) {
		return boardRepository.findAll(PageRequest.of(offset, size));
	}

	public Optional<Board> findBoardById(Long id) {
		return Optional.ofNullable(boardRepository.findBoardById(id));
	}

	public Board save(String title, String content) throws ServiceException {
		Board board = Board.builder()
			.title(title)
			.content(content)
			.build();

		return boardRepository.save(
			Optional.ofNullable(board).orElseThrow(() -> new ServiceException(ErrorCode.POSTING_FAILED)));
	}

	public Board update(Long id, String title, String content) throws ServiceException {
		Board board = findBoardById(id)
			.orElseThrow(() -> new ServiceException(ErrorCode.POST_NOT_FOUND));

		board.update(Optional.ofNullable(title), Optional.ofNullable(content));

		return boardRepository.save(Optional.ofNullable(board).orElseThrow(() -> new ServiceException(ErrorCode.POSTING_FAILED)));
	}

	public void delete(Long id) throws ServiceException {
		Board board = Optional.ofNullable(boardRepository.findBoardById(id))
			.orElseThrow(() -> new ServiceException(ErrorCode.POST_NOT_FOUND));

		boardRepository.delete(board);
	}

}
