package com.prac.home.datastructures.trees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Node{
    Integer data;
    Node lNode;
    Node rNode;
    Node parentNode;
}
