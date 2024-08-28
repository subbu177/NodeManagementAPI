package com.nodeservice.node_backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nodeservice.node_backend.entity.Node;
import com.nodeservice.node_backend.exception.ValidationException;
import com.nodeservice.node_backend.repository.NodeRepository;
import com.nodeservice.node_backend.service.NodeService;

public class NodeServiceTest {
	
	private NodeService nodeService;
    private NodeRepository nodeRepository;

    @BeforeEach
    void setUp() {
        nodeRepository = mock(NodeRepository.class);
        nodeService = new NodeService(nodeRepository);
    }

    @Test
    void testCreateNodeWithValidData() {
        Node node = new Node();
        node.setNodeId("T300_016");
        node.setNodeName("Valid Node Name");

        when(nodeRepository.save(any(Node.class))).thenReturn(node);

        Node createdNode = nodeService.createNode(node);

        assertNotNull(createdNode);
        assertEquals("T300_016", createdNode.getNodeId());
    }

    @Test
    void testCreateNodeWithInvalidNodeId() {
        Node node = new Node();
        node.setNodeId("T300_016$");  // Invalid ID
        node.setNodeName("Valid Node Name");

        ValidationException exception = assertThrows(ValidationException.class, () -> {
            nodeService.createNode(node);
        });

        assertEquals("Node ID contains invalid characters", exception.getMessage());
    }

    @Test
    void testCreateNodeWithNullNodeId() {
        Node node = new Node();
        node.setNodeId(null);  // Null ID
        node.setNodeName("Valid Node Name");

        ValidationException exception = assertThrows(ValidationException.class, () -> {
            nodeService.createNode(node);
        });

        assertEquals("Node ID is mandatory and cannot be null or empty", exception.getMessage());
    }

}
