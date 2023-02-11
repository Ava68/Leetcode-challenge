class Pair{
    int node, dist, color; 
    Pair(int node, int dist, int color){
        this.node = node;
        this.dist = dist;
        this.color = color;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        ArrayList<ArrayList<Integer>> red = new ArrayList<>();
        ArrayList<ArrayList<Integer>> blue = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }

        for(int i=0; i<redEdges.length; i++){
            red.get(redEdges[i][0]).add(redEdges[i][1]);
        }

        for(int i=0; i<blueEdges.length; i++){
            blue.get(blueEdges[i][0]).add(blueEdges[i][1]);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, -1)); // 0 denotes RED, 1 denotes BLUE

        int dist[] = new int[n];
        for(int i=0; i<n; i++) { dist[i] = Integer.MAX_VALUE; }
        dist[0] = 0;
        
        while(!q.isEmpty()){
            int node = q.peek().node;
            int d = q.peek().dist;
            int color = q.poll().color;
            
            dist[node] = Math.min(dist[node], d);

            // for adding used edges to delete them later
            ArrayList<Integer> removeRed = new ArrayList<>();
            ArrayList<Integer> removeBlue = new ArrayList<>();

            if(color == -1) {
                for(int adjNode : red.get(node)){
                    q.add(new Pair(adjNode, d+1, 0));
                    removeRed.add(adjNode);
                }

                for(int adjNode : blue.get(node)){
                    q.add(new Pair(adjNode, d+1, 1));
                    removeBlue.add(adjNode);
                }

            }
            else if(color == 0){ // red
                for(int adjNode : blue.get(node)){
                    q.add(new Pair(adjNode, d+1, 1));
                    removeBlue.add(adjNode);
                }
            }
            else { //blue
                for(int adjNode : red.get(node)){
                    q.add(new Pair(adjNode, d + 1, 0));
                    removeRed.add(adjNode);
                }
            }

            // removing used edges
            for(int adjNode : removeRed){
                red.get(node).remove(Integer.valueOf(adjNode));
            }
            for(int adjNode : removeBlue){
                blue.get(node).remove(Integer.valueOf(adjNode));
            }
            
        }

        for(int i=0; i<n; i++){
            if(dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }

        return dist;
    }
}

