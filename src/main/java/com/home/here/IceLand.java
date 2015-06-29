package com.home.here;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class IceLand {

    public static void main(String[] args) {
        // criticalBridges( 5,
        // "({A,B,C,D,E,F,G},{A,B},{B,C},{C,A},{B,D},{A,E},{A,G},{D,F},{E,F}),({A,B,C,D,E},{B,A},{A,C},{C,B},{A,D},{D,E}),({A,B,C,D},{A,B},{B,C},{C,D}),({A,B,C,D,E},{A,B},{B,C},{C,A},{E,D},{D,A}),({A,B,C,D,E,F},{A,C},{B,C},{C,E},{B,E},{B,D},{E,F})");

        System.out.println(criticalBridges(1, "({A,B,C,D,E,F},{(A,C),(B,C),(C,E),(B,E),(B,D),(E,F)})"));

//        System.out.println(criticalBridges(2,
//                "({A,B,C},{(A,B),(B,C),(C,A)}),({A,B,C,D,E},{(A,B),(B,C),(C,A),(E,D),(D,A)})"));
    }

    private static Map<String, Vertex> graphData = new HashMap<String, Vertex>();
    private static int time = 0;

    public static String criticalBridges(int input1, String input2) {
        String result = "";
        List<String> testCases = new ArrayList<String>();

        for (int i = 0; i < input1; i++) {
            if (input2.indexOf("})") != -1) {
                testCases.add(input2.substring(0, input2.indexOf("})") + 2));
                if (input2.length() > (input2.indexOf("})") + 2)) {
                    input2 = input2.substring(input2.indexOf("})") + 3, input2.length());
                }
            }
        }
        if (testCases.size() > 0) {
            for (String testString : testCases) {
                if (testString.indexOf("},{") != -1) {
                    String vertexes[] = testString.substring(testString.indexOf("({") + 2, testString.indexOf("},{"))
                            .trim().split(",");
                    for (int j = 0; j < vertexes.length; j++) {
                        graphData.put(vertexes[j], new Vertex(vertexes[j]));
                    }
                    testString = testString.substring(testString.indexOf("},{") + 3, testString.length() - 2);
                    String edges[] = testString.trim().replace("),(", ");(").split(";");
                    for (int j = 0; j < edges.length; j++) {
                        edges[j] = edges[j].replace("(", " ").replace(")", " ").trim();
                        String edgeBetweenVertex[] = edges[j].split(",");
                        graphData.get(edgeBetweenVertex[0].trim()).edges.add(new Vertex(graphData
                                .get(edgeBetweenVertex[1].trim()).value));
                        graphData.get(edgeBetweenVertex[1].trim()).edges.add(new Vertex(graphData
                                .get(edgeBetweenVertex[0].trim()).value));
                    }
                }
                if (result.length() == 0) {
                    result = getCriticalEdges() + ",";
                    graphData.clear();
                    time = 0;
                } else {
                    result += getCriticalEdges() + ",";
                    graphData.clear();
                    time = 0;
                }
            }
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

    public static String getCriticalEdges() {
        Map<String, Boolean> visited = new HashMap<String, Boolean>(graphData.size());
        Map<String, Integer> disc = new HashMap<String, Integer>(graphData.size());
        Map<String, Integer> low = new HashMap<String, Integer>(graphData.size());
        Map<String, String> parent = new HashMap<String, String>(graphData.size());

        for (String vertexValue : graphData.keySet()) {
            disc.put(vertexValue, 0);
            low.put(vertexValue, 0);
            disc.put(vertexValue, 0);
            visited.put(vertexValue, false);
        }

        List<String> criticalList = new ArrayList<String>();
        for (String vertexValue : graphData.keySet()) {
            if (visited.get(vertexValue) == null || visited.get(vertexValue) == false)
                criticalEdges(vertexValue, visited, disc, low, parent, criticalList);
        }

        String result = "{";
        if (criticalList == null || criticalList.size() == 0) {
            result = "{NA}";
        } else {
            Collections.sort(criticalList);
            for (String edgeV : criticalList) {
                result += edgeV + ",";
            }
            result = result.substring(0, result.length() - 1) + "}";
        }
        return result;
    }

    public static void criticalEdges(String vertexValue, Map<String, Boolean> visited, Map<String, Integer> disc,
            Map<String, Integer> low, Map<String, String> parent, List<String> criticalList) {
        visited.put(vertexValue, true);
        disc.put(vertexValue, ++time);
        low.put(vertexValue, ++time);
        LinkedHashSet<Vertex> adjacEdges = graphData.get(vertexValue).edges;
        if (adjacEdges != null && adjacEdges.size() > 0) {
            for (Vertex vertex : adjacEdges) {
                if (!visited.get(vertex.getValue())) {
                    parent.put(vertex.getValue(), vertexValue);
                    criticalEdges(vertex.getValue(), visited, disc, low, parent, criticalList);

                    low.put(vertexValue, Math.min(low.get(vertexValue), low.get(vertex.getValue())));
                    if (low.get(vertex.getValue()) > disc.get(vertexValue))
                        criticalList.add("(" + (vertexValue.charAt(0) > vertex.getValue().charAt(0)?vertex.getValue()+","+vertexValue:vertexValue+","+vertex.getValue())+ ")");
                } else if (vertex.getValue() != parent.get(vertexValue))
                    low.put(vertexValue, Math.min(low.get(vertexValue), disc.get(vertex.getValue())));
            }
        }
    }

    static class Vertex {
        private String value;
        public LinkedHashSet<Vertex> edges;

        public Vertex(String value) {
            this.value = value;
            this.edges = new LinkedHashSet<Vertex>();
        }

        public String getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return "Vertex [value=" + value + (edges.size() > 0 ? ", edges= " + edges : "") + "]";
        }

    }
}
