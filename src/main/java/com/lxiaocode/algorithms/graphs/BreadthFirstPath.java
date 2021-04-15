package com.lxiaocode.algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于广度优先搜索的最短路径搜索
 *
 * @author lixiaofeng
 * @date 2021/4/12 下午16:55
 * @blog http://www.lxiaocode.com/
 */
public class BreadthFirstPath {

    private boolean[] marked;
    private int[] edgeTo;
    private int start;

    public BreadthFirstPath(Graph graph, int start){
        this.marked = new boolean[graph.vertex()];
        this.edgeTo = new int[graph.vertex()];
        this.start = start;
        bfs(graph, start);
    }

    public boolean hasPathTo(int v){
        return this.marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        // TODO
        return null;
    }

    private void bfs(Graph graph, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(! queue.isEmpty()){
            Integer v = queue.poll();
            for (int w : graph.adj(v)){
                if (! this.marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }

        }

    }
}
