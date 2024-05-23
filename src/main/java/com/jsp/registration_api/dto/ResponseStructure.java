package com.jsp.registration_api.dto;

import lombok.Data;

@Data
public class ResponseStructure<D>{
	private String message;
	private D data;
	private int status;
}
