package com.lxiaocode.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 无向图
 *
 * @author lixiaofeng
 * @date 2021/4/12 上午11:23
 * @blog http://www.lxiaocode.com/
 */
public class Graph {

    private final int vertex;
    private int edge;
    private final Set<Integer>[] adj;

    public Graph(int vertex){
        this.vertex = vertex;
        this.edge = 0;
        this.adj = (Set<Integer>[]) new Set[vertex];
        for (int i = 0; i < vertex; i++){
            adj[i] = new HashSet<>();
        }
    }

    public int vertex(){
        return this.vertex;
    }
    public int edge(){
        return this.edge;
    }

    public void addEdge(int v, int w){
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.edge++;
    }

    public Iterable<Integer> adj(int vertex){
        return adj[vertex];
    }
}
