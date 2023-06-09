package predprey.app;

import predprey.living.World;


public class App {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to Predator Prey simulation!!");
        final int world_size = 10;
        World w1 = new World(world_size), w2 = new World(world_size);
        int index = 0;
        final int cycles = 2;
        w2.eden();
        System.out.printf("Cycle = %d\n\n%n", index);
        System.out.println(w2);

        for (index = 1; index <= cycles; ++index) {

            System.out.printf("Cycle = %d\n\n%n", index);
            if (index % 2 == 0) {
                w2.update(w1);
                System.out.println(w2);
            }
            else {
                w1.update(w2);
                System.out.println(w1);
            }
        }
    }
}