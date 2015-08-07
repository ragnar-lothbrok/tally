package com.home.heap;


public class MainClass {

    public static void main(String[] args) {

        String str[] = { "Ram", "Shyam", "Rosie", "Mohan", "Barney", "Barney", "Betty", "Bam Bam", "Jetsons", "George",
                "Flintstones", "Jane", "Elroy", "Judy", "Flintstones", "Rosie", "Bam Bam", "Mohan", "Scooby Doo Gang",
                "Mohan", "Scooby Doo", "Mohan", "Rosie", "Barney", "Scooby Doo" };
        HeapConstructionService<String> heapConstructionService = new HeapConstructionService<String>();
        for (String value : str) {
            heapConstructionService.addoToHeap(new HeapNode<String>(value, 1));
        }
        System.out.println(heapConstructionService.getHeapNodesList());
        
        System.out.println(heapConstructionService.getTopHeapNodes(3));
    }

}
