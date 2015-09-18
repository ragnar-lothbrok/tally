package com.home.flipkart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// http://www.programcreek.com/2012/12/leetcode-word-ladder/
public class WordTranformation {

    public static void main(String[] args) {
        Set<String> nodes = new HashSet<String>();
        nodes.add("hot");
        nodes.add("dot");
        nodes.add("pot");
        nodes.add("dog");
        nodes.add("lot");
        nodes.add("log");
        nodes.add("cit");
        nodes.add("cot");

        String startWord = "hit";
        String endWord = "cog";

//        countTransformationSteps(nodes, startWord, endWord);
        getTransformationPath(nodes, startWord, endWord);

    }

    private static void getTransformationPath(Set<String> nodes, String start, String end) {
        nodes.add(end);
        Set<String> visitedString = new HashSet<String>();
        Set<String> unvisited = new HashSet<String>();
        unvisited.addAll(nodes);
        
        Queue<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(start, 1, null));
        visitedString.add(start);
        
        int preNumSteps = 0;
        while(!queue.isEmpty()){
            WordNode poppedNode = queue.remove();
            
            if(poppedNode.getWord().equals(end)){
                WordNode temp = poppedNode;
                List<String> list = new ArrayList<String>();
                list.add(end);
                while(temp.getPreNode() !=null){
                    list.add(temp.getPreNode().getWord());
                    temp = temp.getPreNode();
                }
                Collections.reverse(list);
                System.out.println("######"+list);
            }
            
//            if(preNumSteps < poppedNode.getNumSteps()){
//                unvisited.removeAll(visitedString);
//            }
//            preNumSteps = poppedNode.getNumSteps();
            
            char[] chArr = poppedNode.getWord().toCharArray();
            Set<String> tempSet = new HashSet<String>();
            for (int i = 0; i < chArr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = chArr[i];
                    if (chArr[i] != c) {
                        chArr[i] = c;
                    }
                    String newWord = new String(chArr);
                    if (unvisited.contains(newWord) && !visitedString.contains(newWord)) {
                        queue.add(new WordNode(newWord, poppedNode.getNumSteps() + 1,poppedNode));
                        tempSet.add(newWord);
                    }
                    chArr[i] = temp;
                }
            }
            visitedString.addAll(tempSet);
            
        }
    }

    private static void countTransformationSteps(Set<String> nodes, String start, String end) {
        int count = 0;
        Queue<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(start));
        nodes.add(end);
        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.getWord();

            if (word.equals(end)) {
                count = top.getNumSteps() + 1;
                break;
            }
            char[] chArr = word.toCharArray();
            for (int i = 0; i < chArr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = chArr[i];
                    if (chArr[i] != c) {
                        chArr[i] = c;
                    }
                    String newWord = new String(chArr);
                    if (nodes.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.getNumSteps() + 1));
                        nodes.remove(newWord);
                    }
                    chArr[i] = temp;
                }
            }
        }
        System.out.println(count);
    }

    static class WordNode {
        private String word;
        private Integer numSteps = 0;
        private WordNode preNode;

        public WordNode() {

        }

        public WordNode(String word) {
            super();
            this.word = word;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public Integer getNumSteps() {
            return numSteps;
        }

        public void setNumSteps(Integer numSteps) {
            this.numSteps = numSteps;
        }

        @Override
        public String toString() {
            return "WordNode [word=" + word + ", numSteps=" + numSteps + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((word == null) ? 0 : word.hashCode());
            return result;
        }

        public WordNode(String word, Integer numSteps) {
            super();
            this.word = word;
            this.numSteps = numSteps;
        }

        public WordNode(String word, Integer numSteps, WordNode preNode) {
            super();
            this.word = word;
            this.numSteps = numSteps;
            this.preNode = preNode;
        }

        public WordNode getPreNode() {
            return preNode;
        }

        public void setPreNode(WordNode preNode) {
            this.preNode = preNode;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            WordNode other = (WordNode) obj;
            if (word == null) {
                if (other.word != null)
                    return false;
            } else if (!word.equals(other.word))
                return false;
            return true;
        }

    }
}
