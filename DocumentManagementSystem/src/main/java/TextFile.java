import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class TextFile {
	private final Map<String, String> attributes;
	private final List<String> lines;
	
	TextFile(final File file) throws IOException {
		attributes = new HashMap<>();
		attributes.put(Attributes.PATH, file.getPath());
		lines = Files.lines(file.toPath()).collect(Collectors.toList());
	}
	
	Map<String, String> getAttributes() {
		return attributes;
	}
	
	void addLineSuffix(final String prefix, final String attributeName) {
		for(int i = 0; i < lines.size(); i++) {
			final String line = lines.get(i);
			if(line.startsWith(prefix) ) {
				attributes.put(attributeName, line.substring(prefix.length()));
				break;
			}
		}
	}
	
	int addLines(
			final int start,
			final Predicate<String> isEnd,
			final String attributeName) {
		
		final StringBuilder accumulator = new StringBuilder();
		int lineNumber;
		
		for(lineNumber = start; lineNumber < lines.size(); lineNumber++) {
			final String line = lines.get(lineNumber);
			if(isEnd.test(line)) {
				break;
			}
			
			accumulator.append(line);
			accumulator.append("\n");
		}
		
		attributes.put(attributeName, accumulator.toString().trim());
		
		return lineNumber;
	}
}
