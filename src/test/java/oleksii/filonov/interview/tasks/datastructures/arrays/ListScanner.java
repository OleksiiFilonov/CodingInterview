package oleksii.filonov.interview.tasks.datastructures.arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListScanner {

    public static List<Integer> read(String inputFile) {
        File resourceDir = Paths.get("src", "test", "resources").toFile();
        try (Scanner scan = new Scanner(Paths.get(resourceDir.getPath(), inputFile).toFile())) {
            int size = scan.nextInt();
            List elements = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                elements.add(scan.nextInt());
            }
            return elements;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
