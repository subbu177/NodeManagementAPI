package com.nodeservice.node_backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodeservice.node_backend.entity.Node;
import com.nodeservice.node_backend.exception.ValidationException;
import com.nodeservice.node_backend.service.NodeService;

@RestController
@RequestMapping("/api/nodes")
@Validated
public class NodeController {

	@Autowired
	private NodeService nodeService;
	
	public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

	@PostMapping
	public ResponseEntity<Node> createNode(@Valid @RequestBody Node node) {
		Node createdNode = nodeService.createNode(node);
		return new ResponseEntity<>(createdNode, HttpStatus.CREATED);
	}

	@GetMapping
	public List<Node> getAllNodes() {
		return nodeService.getAllNodes();
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(ValidationException e) {
		ErrorResponse errorResponse = new ErrorResponse(e.getFieldName(), e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}

class ErrorResponse {

	private String field;
	private String message;

	public ErrorResponse(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
