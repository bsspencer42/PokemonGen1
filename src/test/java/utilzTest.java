import Objects.Level;
import helpz.utilz;

public class utilzTest {

    public static void main(String[] args) {
        int[][] lvl = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
        int[][] lvl2 = {
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
        };

        Level gameLvl = new Level(lvl,lvl2);

        int[] oneArr = utilz.TwoDto1DintArr(gameLvl);
        for (int i = 0; i < oneArr.length; i++) {
            System.out.print(oneArr[i] + ", ");
        }



    }
}
