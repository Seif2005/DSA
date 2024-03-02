package Data_Structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private class Vertex{
        public char label;
        public boolean wasVisited;
        public Vertex(char label){
            this.label = label;
            wasVisited = false;
        }
    }
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];//array of vertices
    private int adjMat[][];//adjacency matrix
    private int nVerts;//current number of vertices
    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        //set adjacency matrix to zeros
        for (int i = 0;i<MAX_VERTS;i++){
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] =0;
            }
        }
    }
    //adding vertex
    public void addVertex(char label){
        vertexList[nVerts++] = new Vertex(label);
    }
    //adding an edge
    public void addEdge(int start,int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }
    public int getAdjUnvisitedVertex(int v){
        for (int j =0;j<nVerts;j++){
            if (adjMat[v][j]==1&&vertexList[j].wasVisited==false){
                return j;//find such first vertex
            }
        }
        return -1;//no such vertices
    }
    public void dfs(){//depth first search
        Stack<Integer> theStack= new Stack<>();
        vertexList[0].wasVisited=true;
        displayVertex(0);
        while(!theStack.isEmpty()){
            //get an unvisited vertex adjacent to the top of the stack
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v==-1){//no such vertex
                theStack.pop();//pop a new one
            }else {//if it exists
                vertexList[v].wasVisited = true;//visit it
                displayVertex(v);//display it
                theStack.push(v);//push it
            }
        }//end while
        //stack is empty so we are done
        //resetting flags
        for (int j = 0;j<nVerts;j++){
            vertexList[j].wasVisited = false;
        }
    }
    public void bfs(){
        Queue<Integer> thequeue= new LinkedList<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        thequeue.add(0);//insert at tail
        int v2;//
        while(!thequeue.isEmpty()){
            int v1 = thequeue.remove();//remove vertex at head
            //until it has no unvisited neighbors
            while((v2 =getAdjUnvisitedVertex(v1))!=-1){
                vertexList[v2].wasVisited = true;//mark it
                displayVertex(v2);//display it
                thequeue.add(v2);
            }//end while(unvisited neighbors)
        }//end while(queue not empty)
        //queue is empty so we are done
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;//reset flags
        }
    }
}
