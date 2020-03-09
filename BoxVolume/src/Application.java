import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Input value for the box's height:");
        int height = new Scanner(System.in).nextInt();
        System.out.println("Input value for the box's width:");
        int width = new Scanner(System.in).nextInt();
        System.out.println("Input value for the box's depth:");
        int depth = new Scanner(System.in).nextInt();
        Box box = new Box(height,width,depth);
        Integer volume;
        volume = box.getVolume();

        System.out.printf("The volume for the given parameters for the box is: %d", volume);

    }
}
