package com.home.graphs;

public class MainClass {

    private static String vertxes = "ABCDEFGHI";
    private static String edges = "AB-BF-FH-AC-AD-DG-GI-AE";

    public static void main(String[] args) {

        Graph<Character> charGraph = new Graph<Character>();

        {
            vertxes = "ABCDE";
            edges = "AB-AC-AD-AE-BC-BD-BE-CD-CE-DE";

        }

        {
            vertxes = "ABCDEFGH";
            edges = "AD-AE-BE-CF-DG-EG-FH-GH";
            charGraph.setDirectedGraph(true);
        }

        {
            vertxes = "ABCDEF";
            edges = "AB6-AD4-BC10-BD7-BE8-CD8-CE5-CF6-DE12-EF7";
            charGraph.setDirectedGraph(false);
        }
        
        {
            vertxes = "ABCDE";
            edges = "AB50-AD80-BC60-BD90-CE40-DC20-DE70-EB50";
            charGraph.setDirectedGraph(true);
        }

        charGraph.setNumOfVertex(vertxes.length());

        for (int i = 0; i < vertxes.length(); i++) {
            charGraph.addVertex(vertxes.charAt(i));
        }

        String str[] = edges.trim().split("-");
        for (int i = 0; i < str.length; i++) {
            charGraph.addEdge(str[i].charAt(0), str[i].charAt(1),
                    (str[i].trim().length() == 2 ? 1 : Integer.parseInt(str[i].trim().substring(2))));
        }

         DFSGraph.traverse(charGraph);

        // BFSGraph.traverse(charGraph);

        // MSTGraph.traverse(charGraph);

        // TopologicalSortGraph.traverse(charGraph);
        
        MSTGraph.traverse(charGraph);

    }

}
