package com.nodeservice.node_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "nodes")
@Data
public class Node {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "node_id", nullable = false)
	private String nodeId;

	@Column(name = "node_name", nullable = false)
	private String nodeName;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "memo", length = 255)
	private String memo;

	@Column(name = "node_type")
	private String nodeType;

	@Column(name = "parent_node_group_name")
	private String parentNodeGroupName;

	@Column(name = "parent_node_group_id")
	private String parentNodeGroupId;

	@Column(name = "parent_node_group")
	private String parentNodeGroup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getParentNodeGroupName() {
		return parentNodeGroupName;
	}

	public void setParentNodeGroupName(String parentNodeGroupName) {
		this.parentNodeGroupName = parentNodeGroupName;
	}

	public String getParentNodeGroupId() {
		return parentNodeGroupId;
	}

	public void setParentNodeGroupId(String parentNodeGroupId) {
		this.parentNodeGroupId = parentNodeGroupId;
	}

	public String getParentNodeGroup() {
		return parentNodeGroup;
	}

	public void setParentNodeGroup(String parentNodeGroup) {
		this.parentNodeGroup = parentNodeGroup;
	}


	public Node(Long id, String nodeId, String nodeName, String description, String memo, String nodeType,
			String parentNodeGroupName, String parentNodeGroupId, String parentNodeGroup) {
		super();
		this.id = id;
		this.nodeId = nodeId;
		this.nodeName = nodeName;
		this.description = description;
		this.memo = memo;
		this.nodeType = nodeType;
		this.parentNodeGroupName = parentNodeGroupName;
		this.parentNodeGroupId = parentNodeGroupId;
		this.parentNodeGroup = parentNodeGroup;
	}

	// Default constructor
	public Node() {
	}

}
