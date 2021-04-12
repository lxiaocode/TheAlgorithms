package com.lxiaocode.algorithms.graphs;

/**
 * 深度优先搜索
 *
 * @author lixiaofeng
 * @date 2021/4/12 下午15:26
 * @blog http://www.lxiaocode.com/
 */
public class DepthFirstSearch {

    private final boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph graph, int start){
        this.marked = new boolean[graph.vertex()];
        dfs(graph, start);
    }

    public boolean marked(int w){
        return this.marked[w];
    }

    public int count(){
        return this.count;
    }

    private void dfs(Graph graph, int v){
        this.marked[v] = true;
        this.count++;
        for (int w : graph.adj(v)){
            if (! this.marked[w]) dfs(graph, w);
        }
    }
}
