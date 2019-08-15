package coba;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] arr =  new int[3][3];
        for (int row = 0;row<3;row++){
            for(int col=0;col<3;col++){
                arr[row][col] = input.nextInt();
            }
        }

        System.out.println(cost(arr));
    }

    public static int cost(int[][] arrMagic) {
        int[] flatArray = Arrays.stream(arrMagic)
                .flatMapToInt(Arrays::stream)
                .toArray();

        int[][] original = {
                {8, 1, 6, 3, 5, 7, 4, 9, 2},
                {6, 1, 8, 7, 5, 3, 2, 9, 4},
                {8, 3, 4, 1, 5, 9, 6, 7, 2},
                {4, 3, 8, 9, 5, 1, 2, 7, 6},
                {6, 7, 2, 1, 5, 9, 8, 3, 4},
                {2, 7, 6, 9, 5, 1, 4, 3, 8},
                {4, 9, 2, 3, 5, 7, 8, 1, 6},
                {2, 9, 4, 7, 5, 3, 6, 1, 8}
        };

        int result = Integer.MAX_VALUE;
        for(int row =0;row<8;row++){
            int memory = 0;
            for(int col=0;col<9;col++){
                memory += Math.abs(flatArray[col]- original[row][col]);
            }

            if (row == 0){
                result = memory;
            }else{
                if (memory < result){
                    result = memory;
                }
            }
        }
        return result;
    }


}


