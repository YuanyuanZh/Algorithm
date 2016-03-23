package Interview;


import java.util.Random;

public class RandomGenerate {

    public static int randomGenerate(int[][] input) {
        int a = 0;
        for ( int i = 0; i< input.length; i++) {
            a += input[i][1];
        }
        int bound = 0;
        Random random = new Random();

        for (int i = 0; i < input.length; i++){
            int d = random.nextInt(a+1);
            bound += input[i][1];
            if (d < bound) {
                return input[i][0];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] input = {{100,1},{200,2},{300,3}};
        int oneh = 0;
        int twoh = 0;
        int threeh = 0;
        for (int i = 0; i < 10000; i++){
            int rst = randomGenerate(input);
            if (rst == 100) oneh++;
            else if (rst == 200) twoh++;
            else if (rst == 300) threeh++;
        }
        System.out.println(oneh);
        System.out.println(twoh);
        System.out.println(threeh);
    }
}
