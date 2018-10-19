package com.kafang.atgo.restful.dto.rep;

import lombok.Getter;

import javax.ws.rs.core.Response;

/**
 * restful response entity
 *
 * @author xuejian.sun
 * @date 2018/10/8
 */
@Getter
public class ResponseTemplate<T> {
	/**
	 * http状态码 reference : javax.ws.rs.core.Response.Status
	 */
	private int httpCode;

	/**
	 * 错误消息
	 */
	private String errorMsg;
	/**
	 * 返回值
	 */
	private T responseEntity;
	/**
	 * 自定义码 1 ===> 成功 -1 ===> 失败
	 */
	private int code;

	private ResponseTemplate(int httpCode, String errorMsg, T responseEntity, int code) {
		this.httpCode = httpCode;
		this.errorMsg = errorMsg;
		this.responseEntity = responseEntity;
		this.code = code;
	}

	private ResponseTemplate() {
	}

	/**
	 * 成功
	 *
	 * @param t
	 * @param   <T>
	 * @return
	 */
	public static <T> ResponseTemplate<T> ok(T t) {
		return new Builder<T>(Response.Status.OK).code(1).responseEntity(t).build();
	}

	/**
	 * 无返回值
	 * 
	 * @return
	 */
	public static <T> ResponseTemplate<T> ok() {
		return new Builder<T>(Response.Status.OK).code(1).build();
	}

	/**
	 * @param status 前端请求参数错误Status = Response.Status.BAD_REQUEST, 后端代码错误 Status =
	 *               Response.Status.INTERNAL_SERVER_ERROR 按错误类型选择合适的状态码
	 * @return ResponseTemplate
	 */
	public static <T> ResponseTemplate<T> failed(Response.Status status, String errorMsg) {
		if (status == null) {
			status = Response.Status.BAD_REQUEST;
		}
		return new Builder<T>(status).code(-1).errorMsg(errorMsg).build();
	}

	public static class Builder<T> {
		private final Response.Status httpStatus;
		private String errorMsg;
		private T responseEntity;
		private int code;

		public Builder(Response.Status httpStatus) {
			if (httpStatus == null) {
				throw new NullPointerException("httpStatus must be not null");
			}
			this.httpStatus = httpStatus;
		}

		public Builder<T> code(int code) {
			this.code = code;
			return this;
		}

		public Builder<T> errorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
			return this;
		}

		public Builder<T> responseEntity(T responseEntity) {
			this.responseEntity = responseEntity;
			return this;
		}

		public ResponseTemplate<T> build() {
			return new ResponseTemplate<>(httpStatus.getStatusCode(), errorMsg, responseEntity, code);
		}
	}
}
