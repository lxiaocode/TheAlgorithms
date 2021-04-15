package com.lxiaocode.algorithms.graphs;

/**
 * 基于DFS，求图的连通分量
 *
 * @author lixiaofeng
 * @date 2021/4/15 下午15:43
 * @blog http://www.lxiaocode.com/
 */
public class ConnectedComponent {

    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponent(Graph graph){
        this.marked = new boolean[graph.vertex()];
        this.id = new int[graph.vertex()];
        for (int v = 0; v < graph.vertex(); v++){
            if (!this.marked[v]){
                dfs(graph, v);
                count++;
            }
        }
    }

    public boolean connected(int v, int w){
        return this.id[v] == this.id[w];
    }
    public int id(int v){
        return this.id[v];
    }
    public int count(){
        return this.count;
    }

    private void dfs(Graph graph, int v){
        this.marked[v] = true;
        this.id[v] = count;
        for (int w : graph.adj(v)){
            if (!this.marked[w]) dfs(graph, w);
        }
    }
}
