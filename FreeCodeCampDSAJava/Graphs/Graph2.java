
//adjacency List representation

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph2 {
 LinkedList<Integer>[] adj; // arr of Linked list
 private int V; // num of vertices in graph
 private int E; // num of edges in graph

  
 public Graph2(int nodes){
    this.V = nodes;
    this.E = 0;
    this.adj = new LinkedList[nodes];
    for(int i = 0 ; i<nodes; i++){
        this.adj[i] = new LinkedList<>(); // intialise linked list
    }
 }

 public void addEdge(int u, int v){
    this.adj[u].add(v);
    this.adj[v].add(u);
    E++;
 }
public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(V+" vertices ," + E+" edges \n");
    for (int v = 0; v < V; v++) {
        sb.append(v+" : ");
        for(int w : adj[v]){
            sb.append(w+" ");
        }
        sb.append("\n");
    }
    return sb.toString(); 
}

// breadth first search
public void bfs(int s){
    boolean[] visited = new boolean[V]; // intially all marked as false
    // boolean array keeps track of visited nodes

    Queue<Integer> q = new LinkedList<>(); //FIFO
    visited[s] = true;
    q.offer(s);
    while(!q.isEmpty()){
        int u = q.poll();
        System.out.print(u+" ");
        for(int v:adj[u]){
            if(!visited [v]){
                visited[v] = true;
                q.offer(v); 
            }
        }
    }
     
}

// depth first search
public void dfs(int s){
    boolean[] visited = new boolean[V];
    Stack<Integer> stack = new Stack<>(); //LIFO
    stack.push(s);
    while(!stack.isEmpty()){
        int u = stack.pop();
        if(!visited [u]){
            visited[u] = true;
            System.out.print(u+" ");
            for(int v:adj[u]){
                if(!visited[v]){
                    stack.push(v); 
                }
            }
        }
    } 
}

// recursive depth first search (undirected graph)
 public void dfs(){
    boolean[] visited = new boolean[V];

    for(int v = 0 ; v<V ; v++){
        if(!visited [v]){
            dfs(v,visited);
        }
    }
 }
 public void dfs(int v, boolean[] visited){
    visited[v] = true;
    System.out.println(v+" ");
    for(int w : adj[v]){
        if(!visited[w]){
            dfs(w, visited); // recursive call
        }
    }
 }

//  connected components (Undirected Graph)
boolean[] visited = new boolean[V];
int[] compId = new int[V]; //compId -> component ID ,  arr
int count = 0;
   public void dfs2(){
   
    for(int v = 0; v<V ; v++){
        if(!visited[v]){
            dfs2(v,visited,compId,count);
            count++;
        }
    }
   }
   public void dfs2(int v,boolean[] visited, int[] compId, int count){
    visited[v] = true;
    compId[v] = count;
    for(int w : adj[v]){
        if(!visited[w]){
            dfs2(w,visited,compId,count);
        }
    }
   }
   public int getCountConnected(){
    return count;
   }
   public boolean isConnected(int x,int y){
    return compId[x] == compId[y];
   }

   
    public static void main(String[] args) {
        Graph2 g = new Graph2(5);
       g.addEdge(0, 1); 
       g.addEdge(1, 2 ); 
       g.addEdge(2, 3); 
       g.addEdge(3, 0);
       g.addEdge(2, 4);
       System.out.println(g); 
       System.out.println("Breadth first search");
       g.bfs(0);
       System.out.println("\nDepth first search");
       g.dfs(0);
    }
}
