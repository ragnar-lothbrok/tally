import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/core-java-developer-2/problems/a12da01bac5c49fe992c261130ca1191/
public class Solution11 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Integer testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {
            line = br.readLine();
            String str[] = line.trim().split(" ");
            int row = Integer.parseInt(str[0]);
            int col = Integer.parseInt(str[1]);
            char[][] charMat = new char[row][col];
            for (int j = 0; j < row; j++) {
                line = br.readLine().trim();
                str = line.split(" ");
                for (int k = 0; k < col; k++) {
                    charMat[j][k] = str[k].charAt(0);
                }
            }
//            display(charMat);
            int queries = Integer.parseInt(br.readLine());
            for (int k = 0; k < queries; k++) {
                str = br.readLine().split(" ");
                int x1 = Integer.parseInt(str[0]) - 1;
                int y1 = Integer.parseInt(str[1]) - 1;
                int x2 = Integer.parseInt(str[2]) - 1;
                int y2 = Integer.parseInt(str[3]) - 1;

                int minX = (x1 > x2) ? x2 : x1;
                int maxX = (x1 > x2) ? x1 : x2;
                int minY = (y1 > y2) ? y2 : y1;
                int maxY = (y1 > y2) ? y1 : y2;

                int numOfGreen = 0;
                int numOfblue = 0;
                int numOfRed = 0;
                for (int l = minX; l <= maxX; l++) {
                    for (int m = minY; m <= maxY; m++) {
                        switch (charMat[l][m]) {
                            case 'r':
                                numOfRed++;
                                break;
                            case 'g':
                                numOfGreen++;
                                break;
                            case 'b':
                                numOfblue++;
                                break;
                        }
                    }
                }

                if (numOfGreen > numOfblue && numOfGreen > numOfRed) {
                    System.out.println("LISA");
                } else if (numOfGreen < numOfblue && numOfRed < numOfblue) {
                    System.out.println("ANI");
                } else if(numOfRed >  numOfblue && numOfRed > numOfGreen){
                    System.out.println("KUKU");
                }else if(numOfGreen > numOfblue && numOfGreen == numOfRed){
                    System.out.println("LISA");
                }else if(numOfblue > numOfGreen && numOfblue == numOfRed){
                    System.out.println("ANI");
                }else if(numOfGreen > numOfRed && numOfblue == numOfGreen){
                    System.out.println("LISA");
                }

            }

        }

    }

    public static void display(char[][] charMat) {
        for (int i = 0; i < charMat.length; i++) {
            for (int j = 0; j < charMat[0].length; j++) {
                System.out.print(charMat[i][j] + " ");
            }
            System.out.println();
        }
    }

}
