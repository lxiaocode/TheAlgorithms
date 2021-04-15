package com.lxiaocode.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * 有向图
 *
 * @author lixiaofeng
 * @date 2021/4/15 下午17:03
 * @blog http://www.lxiaocode.com/
 */
public class Digraph {

    private int vertex;
    private int edge;
    private Set<Integer>[] adj;

    public Digraph(int vertex){
        this.vertex = vertex;
        this.edge = 0;
        this.adj = (HashSet<Integer>[]) new Set[vertex];
        for (int v = 0; v < vertex; v++){
            adj[v] = new HashSet<>();
        }
    }

    public int vertex(){ return this.vertex; }
    public int edge(){ return this.edge; }

    public void addEdge(int v, int w){
        this.adj[v].add(w);
        this.edge++;
    }

    public Iterable<Integer> adj(int v){
        return this.adj[v];
    }

    public Digraph reverse(){
        Digraph digraph = new Digraph(this.vertex);
        for (int v = 0; v < this.vertex; v++){
            for (int w : this.adj[v]){
                digraph.addEdge(w, v);
            }
        }
        return digraph;
    }
}
