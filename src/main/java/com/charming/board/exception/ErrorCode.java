package com.charming.board.exception;


public enum ErrorCode {
	POST_NOT_FOUND(1000, "게시글 찾을 수 없음"),
	POSTING_FAILED(1001, "포스팅 실패");

	private final int code;
	private final String errorMessage;

	ErrorCode(int code, String errorMessage) {
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public int getCode() {
		return code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
