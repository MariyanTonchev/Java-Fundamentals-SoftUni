    import java.util.Scanner;

    public class Snowballs {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int bestSnowballSnow = 0, bestSnowballTime = 0, bestSnowballQuality = 0;
            long  bestSnowballValue = 0;
            int n = scanner.nextInt();
            for(int i = 0; i < n; i++){
                int snowballSnow = scanner.nextInt();
                int snowballTime = scanner.nextInt();
                int snowballQuality = scanner.nextInt();
                long snowballValue = (long) Math.pow((snowballSnow / snowballTime), snowballQuality);
                if(snowballValue > bestSnowballValue){
                    bestSnowballValue = snowballValue;
                    bestSnowballQuality = snowballQuality;
                    bestSnowballSnow = snowballSnow;
                    bestSnowballTime = snowballTime;
                }
            }
            System.out.printf("%d : %d = %d (%d)", bestSnowballSnow, bestSnowballTime, bestSnowballValue, bestSnowballQuality);
        }
    }
