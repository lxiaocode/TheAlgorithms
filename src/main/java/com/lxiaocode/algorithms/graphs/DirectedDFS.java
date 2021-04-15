package com.lxiaocode.algorithms.graphs;

/**
 * 有向图的可达性
 *
 * @author lixiaofeng
 * @date 2021/4/15 下午17:24
 * @blog http://www.lxiaocode.com/
 */
public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(Digraph digraph, int v){
        this.marked = new boolean[digraph.vertex()];
        dfs(digraph, v);
    }

    public boolean marked(int v){
        return this.marked[v];
    }

    private void dfs(Digraph digraph, int v){
        this.marked[v] = true;
        for (int w : digraph.adj(v)){
            if (!this.marked[w]) dfs(digraph, w);
        }
    }
}
