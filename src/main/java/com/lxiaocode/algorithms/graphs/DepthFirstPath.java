package com.lxiaocode.algorithms.graphs;

import java.util.Stack;

/**
 * 基于深度优先搜索的路径搜索
 *
 * @author lixiaofeng
 * @date 2021/4/12 下午15:59
 * @blog http://www.lxiaocode.com/
 */
public class DepthFirstPath {

    private final boolean[] marked;
    private final int[] edgeTo;
    private final int start;

    public DepthFirstPath(Graph graph, int start){
        this.marked = new boolean[graph.vertex()];
        this.edgeTo = new int[graph.vertex()];
        this.start = start;
        dfs(graph, start);
    }

    public boolean hasPathTo(int v){
        return this.marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (! hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != this.start; x = this.edgeTo[v]){
            path.push(x);
        }
        path.push(this.start);
        return path;
    }

    private void dfs(Graph graph, int v){
        this.marked[v] = true;
        for (int w : graph.adj(v)){
            if (! this.marked[w]){
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

}
