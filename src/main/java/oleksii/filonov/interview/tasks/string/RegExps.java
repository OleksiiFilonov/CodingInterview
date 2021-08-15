package oleksii.filonov.interview.tasks.string;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RegExps {
	
	private final List<Pattern> patterns;
	
	public RegExps(List<String> regExps) {
		List<Pattern> patterns = new ArrayList<>();
		for (String pattern : regExps) {
			patterns.add(Pattern.compile(pattern));
		}
		this.patterns = patterns;
	}
	

	public boolean matches(String url) {
		for (Pattern pattern : patterns) {
			if(pattern.matcher(url).matches()) {
				return true;
			}
		}
		return false;
	}
	
	
}
