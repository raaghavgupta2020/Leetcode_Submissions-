//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int node;
    int parent;
    public Pair(int node , int parent ){
        this.node= node;
        this.parent=parent;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        //handling connected components 
        for(int i = 0 ; i < V ; i++){
            if(vis[i]==false){
                if(bfs_cycle(i , vis , adj)){
                // if(dfs_cycle(i , vis , adj)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean bfs_cycle(int n , boolean[] vis , ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(n , -1));
        vis[n] = true;
        while(!q.isEmpty()){
            Pair x = q.poll();
            int node = x.node;
            int parent = x.parent;
            for(Integer neighbour : adj.get(node)){
                if(vis[neighbour]==false && neighbour != parent){
                    vis[neighbour] = true;
                    q.offer(new Pair(neighbour , node));
                }else if(vis[neighbour] == true && neighbour!=parent){
                    //we have found a cycle
                    return true;
                }
            }
        }
        return false;
    }
}









