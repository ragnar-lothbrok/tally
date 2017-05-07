package com.he.capillary.chegg1;

import java.util.Scanner;

public class Driver5 {
	public static void main(String[] args) {
		int n, m, x, y;
		Scanner scan = new Scanner(System.in);
		System.out.print("Number of vertices: ");
		n = scan.nextInt();
		System.out.print("Number of edges: ");
		m = scan.nextInt();
		GraphTclass graph = new GraphTclass(n);
		System.out.println("Enter edges (pairs of indices):");
		for (int i = 0; i < m; i++) {
			x = scan.nextInt();
			y = scan.nextInt();
			graph.addEdge(x, y);
		}

		System.out.println(graph);

		int parts = graph.components();
		String sp = "component";
		if (parts != 1)
			sp += "s";
		System.out.println("Graph has " + parts + " " + sp + ".");

		System.out.println(graph);

		int diam = graph.diameter();
		System.out.println("Graph has diameter " + diam + ".");

	}
}
