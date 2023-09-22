import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        int minsum = 2000;
        int quantity = 0;
        int num;
        int min37 = 10001;
        int max73 = 0;
        int[] nums = new int[1000];
        try (BufferedReader reader = new BufferedReader(new FileReader("17-342.txt"));){
            for(int i=0; i < 1000; i++){
                num = Integer.parseInt(reader.readLine());
                nums[i] = num;
                if ((num % 37 == 0) && (num < min37)) {
                    min37 = num;}
                if ((num % 73 == 0) && (num > max73)) {
                    max73 = num;}}}
        catch(IOException ex){
            System.out.println(ex.getMessage());}
        for(int i=0; i < 1000; i++){
            if (min37 < nums[i] || nums[i] < max73){
                if(i-1 >= 0 &&!(min37 < nums[i-1] || nums[i-1] < max73)){
                    quantity++;
                    int sum = nums[i] + nums[i-1];
                    if (sum < minsum){
                        minsum = sum;}}
                if (i+1 < 1000 &&!(min37 < nums[i+1] || nums[i+1] < max73)){
                    quantity++;
                    int sum = nums[i] + nums[i+1];
                    if (sum < minsum){
                        minsum = sum;}}}}
        System.out.println(minsum);
        System.out.println(quantity);}}