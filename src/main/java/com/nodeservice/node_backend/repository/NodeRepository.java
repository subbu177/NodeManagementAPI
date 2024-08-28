package com.nodeservice.node_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nodeservice.node_backend.entity.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long>{

}
