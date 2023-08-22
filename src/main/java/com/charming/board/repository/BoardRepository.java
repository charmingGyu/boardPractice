/*
 * BoardRepository.java 2023. 08. 23
 *
 * Copyright 2023 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.charming.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.charming.board.entity.Board;

/**

 */
@Repository
@EnableJpaRepositories
public interface BoardRepository extends JpaRepository<Board, Long> {
	Board findBoardById(Long id);

	Page<Board> findAll(Pageable pageable);

	Board save(Board board);

	void delete(Board board);
}
