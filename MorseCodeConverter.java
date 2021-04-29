import java.io.*;
import java.util.Scanner;

public class MorseCodeConverter {
	
	static MorseCodeTree tree = new MorseCodeTree();
	
	public static void main(String[] args) {
		System.out.println(printTree());
		String comp = printTree();
		while(comp.indexOf(',') >= 0) {
			comp = comp.substring(0, comp.indexOf(',')) + comp.substring(comp.indexOf(',') + 1);
		}
		comp = comp.substring(1, comp.length() - 1);
		System.out.println(comp);
		System.out.println(new Boolean(comp.equals("h s v i f u e l r a p w j  b d x n c k y t z g q m o")));
		
		String[] t = " ten cents".split(" ");
		System.out.println("["+t[0]+"}");
	}

	public static String printTree() {
		
		String printed = "";
		for (String next : tree.toArrayList())
			printed += next + " ";
		return printed.substring(0, printed.length() - 1);
	}
	
	public static String convertToEnglish(String code) {
		
		String english = "";
		String[] words = code.split(" / ");
		for (String word : words) {
			
			String engWord = "";
			String[] letters = word.split(" ");
			
			for (String letter : letters)
				engWord += tree.fetch(letter);
			english += " " + engWord;
			
		}
		return english.substring(1);
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		
		Scanner input = new Scanner(codeFile);
		String text = "";
		while(input.hasNextLine())
			text += input.nextLine();
		
		return convertToEnglish(text);
	}
}
