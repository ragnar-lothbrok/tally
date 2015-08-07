package com.home.heap;


public class MainClass {

    public static void main(String[] args) {

        String str[] = { "Ram", "Shyam", "Rosie", "Mohan", "Barney", "Barney", "Betty", "Bam Bam", "Jetsons", "George",
                "Flintstones", "Jane", "Elroy", "Judy", "Flintstones", "Rosie", "Bam Bam", "Mohan",
                "Mohan", "Scooby Doo", "Mohan", "Rosie", "Barney", "Scooby Doo" };
        MaxHeapConstructionService<String> heapConstructionService = new MaxHeapConstructionService<String>();
        
        MinHeapConstructionService<String> heapMinHeapConstructionService = new MinHeapConstructionService<String>();
        for (String value : str) {
            if(value.equalsIgnoreCase("Scooby Doo"))
                System.out.println();
            heapConstructionService.addoToHeap(new HeapNode<String>(value, 1));
            heapMinHeapConstructionService.addoToHeap(new HeapNode<String>(value, 1));
        }
        System.out.println(heapConstructionService.getHeapNodesList());
        
        System.out.println(heapConstructionService.getTopHeapNodes(6));
        
        System.out.println(heapMinHeapConstructionService);
        
        System.out.println(heapMinHeapConstructionService.getTopHeapNodes(12));
    }

}
