package oleksii.filonov.interview.classloading;

import oleksii.filonov.interview.classloading.ImportedButNotUsed;

public class ImportNotUsedClass {
	
	public static void main(String[] args) {
		System.out.println("Main method executed");
		//Unused class is loaded once the instance of the object 
		ImportNotUsedClass test = new ImportNotUsedClass();
	}

}
