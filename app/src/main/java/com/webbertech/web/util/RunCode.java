import java.io.*;

public class RunCode {
	static Result executeCode(SourceCode code)  {
		

		String s = null;
		
		
        try {
            
	    // run the Unix "ps -ef" command
            // using the Runtime exec method to run :
            Process p = Runtime.getRuntime().exec("ls");
            PrintWriter writer = new PrintWriter("log.txt");
            
            BufferedReader stdInput = new BufferedReader(new 
                 InputStreamReader(p.getInputStream()));
            
            BufferedReader stdError = new BufferedReader(new 
                 InputStreamReader(p.getErrorStream()));

            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            writer.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                
                writer.println(s);
            }
            
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            writer.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
                writer.println(s);
            }
            writer.close();
            System.exit(0);
            
            
        }
        catch (IOException e) {
            System.out.println("exception happened - here's what I know: ");
            try {
				PrintWriter writer = new PrintWriter("log.txt");
				String hello = e.toString();
				writer.println(hello);
				writer.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            e.printStackTrace();
            
           
            
            System.exit(-1);
        }
        
        return null;
        
	}

	public static void main(String[] args) throws FileNotFoundException {
		// Test above code here.
		SourceCode hello=null;
		executeCode(hello);
	}

}



