package def;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import keyboard.KeyboardInputHandler;

import decathlon.FieldDecathlonEvent;

public class Tester {

	/**
	 * This is the main sub
	 * @param String[] args - command line arguments passed into the program
	 */
	public static void main(String[] args) {
		
		 BufferedReader br = new BufferedReader(
                 new InputStreamReader(System.in));

		 KeyboardInputHandler kbih = null;
		try {
			kbih = new KeyboardInputHandler(br);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(kbih.getAllResults().get(0));
	}

}
