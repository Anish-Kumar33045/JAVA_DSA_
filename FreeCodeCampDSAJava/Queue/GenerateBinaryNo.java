import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenerateBinaryNo {

    public String[] generate(int n) {
        String[] result = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");

        for (int i = 0; i < n; i++) {
            result[i] = q.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            q.offer(n1);
            q.offer(n2);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number to generate:");
        int n = scanner.nextInt();  // Store the input

        GenerateBinaryNo obj = new GenerateBinaryNo();
        String[] binaryNumbers = obj.generate(n);

        System.out.println("Generated binary numbers:");
        for (String binary : binaryNumbers) {
            System.out.println(binary);
        }

        scanner.close();
    }
}
