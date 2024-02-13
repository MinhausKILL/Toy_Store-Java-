import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Toy_Store {
    private int[] toyIds;
    private String[] toyNames;
    private int[] frequencies;
    private PriorityQueue<Integer> queue;

    public Toy_Store(String[] ids, String[] names, String[] freqs) {
        this.toyIds = new int[ids.length];
        this.toyNames = new String[names.length];
        this.frequencies = new int[freqs.length];

        for (int i = 0; i < ids.length; i++) {
            toyIds[i] = Integer.parseInt(ids[i]);
            toyNames[i] = names[i];
            frequencies[i] = Integer.parseInt(freqs[i]);
        }

        queue = new PriorityQueue<>();
    }

    public void put(int numTimes) {
        for (int i = 0; i < toyIds.length; i++) {
            for (int j = 0; j < frequencies[i]; j++) {
                queue.add(toyIds[i]);
            }
        }

        for (int i = 0; i < numTimes; i++) {
            int result = queue.poll();
            System.out.println("Get: " + result);
            writeToFile("output.txt", "Get: " + result + "\n");
        }
    }

    private void writeToFile(String filename, String data) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] ids = {"1", "2", "3"};
        String[] names = {"конструктор", "робот", "кукла"};
        String[] freqs = {"2", "2", "6"};
        Toy_Store toyConstructor = new Toy_Store(ids, names, freqs);
        toyConstructor.put(10);
    }
}
