/*
 * ServiceException.java 2023. 08. 23
 *
 * Copyright 2023 Naver Cloud Corp. All rights Reserved.
 * Naver Business Platform PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.charming.board.exception;

/**

 */
public class ServiceException extends Exception {
	private ErrorCode errorCode;

	public ServiceException(ErrorCode errorCode) {
		super(errorCode.getErrorMessage());
		this.errorCode = errorCode;
	}
}
