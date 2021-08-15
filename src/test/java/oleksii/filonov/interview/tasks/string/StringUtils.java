package oleksii.filonov.interview.tasks.string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StringUtils {
	
	public static String readLine(String fileName) throws IOException {
		Path path = Paths.get("src", "test", "resources", fileName);
		return Files.lines(path).findFirst().get();
	}

}
