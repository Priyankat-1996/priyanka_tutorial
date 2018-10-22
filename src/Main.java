import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;


public class Main{
  public static void main(String[] args) throws IOException {
    Path startingDir = Paths.get("/home");
    FindJavaVisitor listFiles = new FindJavaVisitor();
    Files.walkFileTree(startingDir, listFiles);
    Path file = null;
    String filepath="/home/priyankat/Processed/xyz.csv";
    FileWriter fw=new FileWriter(filepath,false);
    BufferedWriter bw=new BufferedWriter(fw);
    PrintWriter pw=new PrintWriter(bw);
    
    String filepath1="/home/priyankat/Output/";
    FileReader fr=new FileReader(filepath);
    BufferedReader br=new BufferedReader(fr);
      String abc="";
    String str="abc.csv";
    List<String> lines=Files.readAllLines(Paths.get(filepath1+str));
    for(String xyz:lines)
    {
 	
 	  xyz=xyz.replace(",", "_");
 	
 	 pw.println(xyz);
 	  pw.flush();
    }
    File directory = new File(filepath1);
    
	
	if(directory.exists())
	{
		System.out.println("File not deleted");
		delete(directory);
	}
	else
	{
		System.out.println("File deleted successfully");
	}
	
  }
  public static void delete(File file)
	    	throws IOException{
	 
	    	if(file.isDirectory()){
	 
	    		//directory is empty, then delete it
	    		if(file.list().length==0){
	    			
	    		   file.delete();
	    		   System.out.println("Directory is deleted : " 
	                                                 + file.getAbsolutePath());
	    			
	    		}else{
	    			
	    		   //list all the directory contents
	        	   String files[] = file.list();
	     
	        	   for (String temp : files) {
	        	      //construct the file structure
	        	      File fileDelete = new File(file, temp);
	        		 
	        	      //recursive delete
	        	     delete(fileDelete);
	        	   }
	        		
	        	   //check the directory again, if empty then delete it
	        	   if(file.list().length==0){
	           	     file.delete();
	        	     System.out.println("Directory is deleted : " 
	                                                  + file.getAbsolutePath());
	        	   }
	    		}
	    		
	    	}else{
	    		//if file, then delete it
	    		file.delete();
	    		System.out.println("File is deleted : " + file.getAbsolutePath());
	    	}
	    }
  
}

class FindJavaVisitor extends SimpleFileVisitor<Path> {
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

    if (file.toString().endsWith(".csv")) {
      System.out.println(file.getFileName());
    }
    return FileVisitResult.CONTINUE;
  }
}

 