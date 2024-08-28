package com.nodeservice.node_backend;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nodeservice.node_backend.controller.NodeController;
import com.nodeservice.node_backend.entity.Node;
import com.nodeservice.node_backend.exception.ValidationException;
import com.nodeservice.node_backend.service.NodeService;

public class NodeControllerTest {

	private MockMvc mockMvc;
    private NodeService nodeService;

    @BeforeEach
    void setUp() {
        nodeService = mock(NodeService.class);
        NodeController nodeController = new NodeController(nodeService);
        mockMvc = MockMvcBuilders.standaloneSetup(nodeController).build();
    }

    @Test
    void testAddNodeWithValidData() throws Exception {
        Node node = new Node();
        node.setNodeId("T300_016");
        node.setNodeName("Valid Node Name");

        when(nodeService.createNode(any(Node.class))).thenReturn(node);

        mockMvc.perform(post("/api/nodes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nodeId\": \"T300_016\", \"nodeName\": \"Valid Node Name\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nodeId").value("T300_016"));
    }

    @Test
    void testAddNodeWithInvalidNodeId() throws Exception {
        when(nodeService.createNode(any(Node.class))).thenThrow(new ValidationException("Node ID", "Node ID contains invalid characters"));

        mockMvc.perform(post("/api/nodes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nodeId\": \"T300_016$\", \"nodeName\": \"Valid Node Name\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.field").value("Node ID"))
                .andExpect(jsonPath("$.message").value("Node ID contains invalid characters"));
    }
}
