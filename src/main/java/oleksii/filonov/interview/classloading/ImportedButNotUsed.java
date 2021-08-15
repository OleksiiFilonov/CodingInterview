package oleksii.filonov.interview.classloading;

public class ImportedButNotUsed {
	
	static {
		System.out.println(ImportedButNotUsed.class + " is loaded!!!");
	}

}
