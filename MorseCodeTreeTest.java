

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeTreeTest {
	
	MorseCodeTree tree;
	ArrayList<String> list;

	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
		list = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
		list = null;
	}

	@Test
	public void fetchTest() {
		assertEquals(tree.fetch("."), "e");
		assertEquals(tree.fetch("---"), "o");
		assertEquals(tree.fetch(".--."), "x");
	}

}
