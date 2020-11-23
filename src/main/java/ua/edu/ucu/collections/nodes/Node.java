package ua.edu.ucu.collections.nodes;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Node {
    private Object value;
    private Node prev;
    private Node next;

    public void setDefaultLinks(){
        prev = null;
        next = null;
    }
    public Node(){
        setDefaultLinks();
    }
    public Node(Object value){
        this.value = value;
        setDefaultLinks();
    }
}
