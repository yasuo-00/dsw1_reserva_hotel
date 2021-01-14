package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.service.spec.IUserService;

public class UserRestController {
	
	@Autowired
	IUserService userService;

	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}
}
