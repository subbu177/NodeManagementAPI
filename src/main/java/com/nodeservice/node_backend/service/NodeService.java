package com.nodeservice.node_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nodeservice.node_backend.entity.Node;
import com.nodeservice.node_backend.exception.ValidationException;
import com.nodeservice.node_backend.repository.NodeRepository;

@Service
public class NodeService {

	@Autowired
	private NodeRepository nodeRepository;

	public NodeService(NodeRepository nodeRepository) {
		this.nodeRepository = nodeRepository;
	}

	public Node createNode(Node node) {
		validateNodeFields(node);
		return nodeRepository.save(node);
	}

	private void validateNodeFields(Node node) {
		validateField("Node ID", node.getNodeId(), "^[a-zA-Z0-9_-]+$", true);
		validateField("Node Name", node.getNodeName(), "^[a-zA-Z0-9_\\-\\s]+$", true);
		validateField("Description", node.getDescription(), "^[a-zA-Z0-9_\\-\\s]*$", false, 255);
		validateField("Memo", node.getMemo(), "^[a-zA-Z0-9_\\-\\s]*$", false, 255);
		validateField("Node Type", node.getNodeType(), "^[a-zA-Z0-9_\\-\\s]*$", false);
		validateField("Parent Node Group Name", node.getParentNodeGroupName(), "^[a-zA-Z0-9_\\-\\s]*$", false);
		validateField("Parent Node Group ID", node.getParentNodeGroupId(), "^[a-zA-Z0-9_\\-\\s]*$", false);
		validateField("Parent Node Group", node.getParentNodeGroup(), "^[a-zA-Z0-9_\\-\\s]*$", false);
	}

	private void validateField(String fieldName, String fieldValue, String regex, boolean isMandatory) {
		validateField(fieldName, fieldValue, regex, isMandatory, null);
	}

	private void validateField(String fieldName, String fieldValue, String regex, boolean isMandatory,
			Integer maxLength) {
		if (isMandatory && !StringUtils.hasText(fieldValue)) {
			throw new ValidationException(fieldName, fieldName + " is mandatory and cannot be null or empty");
		}
		if (maxLength != null && fieldValue != null && fieldValue.length() > maxLength) {
			throw new ValidationException(fieldName, fieldName + " must be less than " + maxLength + " characters");
		}
		if (fieldValue != null && !fieldValue.matches(regex)) {
			throw new ValidationException(fieldName, fieldName + " contains invalid characters");
		}
	}

	public List<Node> getAllNodes() {
		return nodeRepository.findAll();
	}
}
