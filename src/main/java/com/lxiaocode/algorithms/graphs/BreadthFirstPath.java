package com.lxiaocode.algorithms.graphs;

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
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(start);
        while(! queue.isEmpty()){
            Integer v = queue.dequeue();
            for (int w : graph.adj(v)){
                if (! this.marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }

        }

    }

    private class Queue<T>{

        private Node head;
        private Node end;
        private int size;

        public Queue(){
            this.head = null;
            this.end = null;
            this.size = 0;
        }
        
        public boolean isEmpty(){
            return this.size == 0;
        }

        public void enqueue(T item){
            if (this.size == 0) {
                Node node = new Node(item, null);
                this.head = node;
                this.end = node;
            }

            this.head.next = new Node(item, null);
            this.head = this.head.next;
            this.size++;
        }

        public T dequeue(){
            if (this.size == 0) return null;

            Node node = this.head;
            this.head = this.head.next;
            this.size--;
            return node.value;
        }

        private class Node{
            private final T value;
            private Node next;

            public Node(T value, Node next){
                this.value = value;
                this.next = next;
            }
        }
    }
}
