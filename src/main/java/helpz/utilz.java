package helpz;

import java.util.ArrayList;

public class utilz {

    public static int[][]  ArrayListTo2Dint(ArrayList<Integer> list,int ySize, int xSize){
        int[][] newArr = new int[ySize][xSize];

        for (int i = 0; i < list.size(); i++) {
            int x = i % 15;
            int y = i / 15;
            newArr[y][x] = list.get(i);
        }
        return newArr;
    }

    public static int[] TwoDto1DintArr(int[][] twoArr){
        int[] oneArr = new int[twoArr.length*twoArr[0].length];
        for (int j = 0; j <twoArr.length; j++) {
            for (int i = 0; i < twoArr[j].length; i++) {
                int index = j* twoArr[j].length + i;
                 oneArr[index] = twoArr[j][i];
            }
        }
        return oneArr;
    }

}
