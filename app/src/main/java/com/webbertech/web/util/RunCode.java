package com.webbertech.web.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RunCode {
	static CodeResult executeCode(SourceCode sourceCode)  {

		String s = null;
		
        try {

            // reconstruct source code to ".java" file
            File newTextFile = new File("HelloWorld.java");
            FileWriter fileWriter = new FileWriter(newTextFile);
            fileWriter.write(sourceCode.code);
            fileWriter.close();

            // using the Runtime exec method to run :
            Runtime runtime = Runtime.getRuntime();
            Process compile = runtime.exec("javac HelloWorld.java");
            Process run = runtime.exec("java HelloWorld");

            PrintWriter printWriter = new PrintWriter("log.txt");

            BufferedReader stdInput = new BufferedReader(new
                 InputStreamReader(run.getInputStream()));

            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(run.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            printWriter.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                printWriter.println(s);
            }
            
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            printWriter.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                printWriter.println(s);
            }

            printWriter.close();
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        }
        
        return null;
        
	}

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

	public static void main(String[] args) throws FileNotFoundException {
		// Test above code here.
        SourceCode sourceCode = null;
        try {
            String codeInString = readFileAsString("/Users/VINCENTWEN/local_workspace/mockingtest-1/app/helloworld.txt");
            sourceCode = new SourceCode("HelloWorld", codeInString);
            executeCode(sourceCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}



