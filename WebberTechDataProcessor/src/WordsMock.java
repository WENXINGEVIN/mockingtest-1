import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordsMock {

	
	//the this the core method to generate sql script from curated data file
	/**
	@param String srcFile,  a curated data file, possibly columns are seperated by one or more tab
	@param String dstFile,  a full path with file name specified, if it is a new file, it will be created. If there is a 
	                        file already, it will be overwritten
	@return              ,  void type
	**/
	public void processFile(String srcFile, String dstFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(srcFile));
		
		//for writting to database
		File file = new File(dstFile);
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line;
		while( (line = br.readLine()) != null) {
			String[] tokens= tokenize2(line);
			
			//write tokens to new file
			if (tokens.length > 1) {
				bw.write(generateSQLStatement(tokens));
				bw.newLine();
			}
			System.out.println(line);   
			
		}
		br.close();
		bw.close();
	}

	
	String formatLineData(String line) {
		line = line.replace("*", "");
		line = line.replace(".", "");
		line = line.replace("&", ",");
		return line;
	}
	
	//tokentize file that is using one or more spaces to seperate columns
	public String[] tokenize(String line) {
		String lineToProcess= formatLineData(line);
		String[] tokens= lineToProcess.split("\\s+");
		return tokens;
	}
	
	//tokenize file that is using one or more tabs to seperate columns
	public String[] tokenize2(String line) {
		String lineToProcess= formatLineData(line);
		String[] tokens= lineToProcess.split("\\t");
		return tokens;
	}
	
	/*
	 * The following method will generate the SQL insert statement from 
	 * token arrays. It will not change the order of the tokens that 
	 * should be repsent in the sql statement. So the raw data file
	 * should already have the right order.
	 * 
	 * eg: 
	 * insert highschool_cn values (null, "abandon","v","·ÅÆú£¬Å×Æú");
	 * */
	public String generateSQLStatement(String[] tokens ) {
		String record = "insert words values (null, ";
		 for (int i=0;i<tokens.length;i++) {
			 record += "\"";
			 record += tokens[i];
			 record += "\"";
			 if (i != tokens.length-1)
			 record += ",";
		 }
		 record+= ");";
		return record;
	} 
	
	
	public void postProcessFile(String srcFile, String dstFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(srcFile));
		
		//for writting to database

		File file = new File(dstFile);
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line;
		while( (line = br.readLine()) != null) {
				bw.write(line+";");
				bw.newLine();
			}
		
		br.close();
		bw.close();
	}
	
	public static void main(String[] args) {
		WordsMock m = new WordsMock();
		try {
			//m.postProcessFile("E:\\WordsMock\\highschool_cn.txt", "E:\\WordsMock\\highschool_cn_final.txt");
		   m.processFile("E:\\WordsMock\\toefl_ibt_category_new.txt", "E:\\WordsMock\\toefl_ibt_category_new.sql.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
