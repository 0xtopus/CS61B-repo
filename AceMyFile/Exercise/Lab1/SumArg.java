public class SumArg{
    public static void main(String[] args) {
        // output the sum of cmd args
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum = sum + Integer.parseInt(args[i]); //convert string to int
        }
        System.out.println(sum);
    }
}