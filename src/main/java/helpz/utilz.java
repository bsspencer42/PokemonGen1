package helpz;

import Objects.Level;

import java.util.ArrayList;

public class utilz {

    public static Level ArrayListTo2Dint(ArrayList<Integer> list,int ySize, int xSize){
        int[][] base = new int[ySize][xSize];
        int[][] base2 = new int[ySize][xSize];

        for (int i = 0; i < list.size()/2; i++) {
            int x = i % 15;
            int y = i / 15;
            base[y][x] = list.get(i);
        }

        for (int i = 0; i < list.size()/2; i++) {
            int x = i % 15;
            int y = i / 15;
            base2[y][x] = list.get(i+150);
        }

        return new Level(base,base2);
    }

    public static int[] TwoDto1DintArr(Level lvl){
        int[][] base = lvl.getBase();
        int[][] base2 = lvl.getBase2();
        int[] oneArr = new int[base.length*base[0].length*2];
        for (int j = 0; j <base.length; j++) {
            for (int i = 0; i < base[j].length; i++) {
                int index = j* base[j].length + i;
                 oneArr[index] = base[j][i];
            }
        }
        for (int j = 0; j <base2.length; j++) {
            for (int i = 0; i < base2[j].length; i++) {
                int index = j* base2[j].length + i;
                oneArr[index+oneArr.length/2] = base2[j][i];
            }
        }

        return oneArr;
    }

}
