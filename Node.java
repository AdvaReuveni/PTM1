package test;

import java.util.*;


public class Node {
    private String name;
    private List<Node> edges;
    private Message msg;


    public Node(String name) {
        this.name = name;
        edges = new ArrayList<>();
        msg = null;
    }
    public void set(String name)
    {
        this.name = name;

    }
    public void setEdges(List<Node> list)
    {
        edges = list;
    }
    public void setMessage(Message m)
    {
        this.msg = m;
    }
    public String getName()
    {
        return this.name;
    }
    public  List<Node> getEdges()
    {
        return this.edges;
    }
    public Message getMessage()
    {
        return this.msg;
    }
    public void addEdge(Node node)
    {
        edges.add(node);
    }

    public boolean hasCycles() {
        return hasCycles(this, new ArrayList<>());
    }

    private boolean hasCycles(Node node, List<Node> visited) {
        if (visited.contains(node)) {
            return true;
        }
        visited.add(node);
        for (Node neighbor : node.getEdges()) {
            if (hasCycles(neighbor, new ArrayList<>(visited))) {
                return true; // Cycle found
            }
        }

        return false; // No cycles found
    }
}