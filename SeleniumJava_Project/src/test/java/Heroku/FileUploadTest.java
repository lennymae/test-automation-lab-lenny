package test.java.Heroku;
import org.testng.annotations.Test;
import main.java.Heroku.FileUpload;

public class FileUploadTest {
	 
	 @Test
	    public void testFileUpload() {
	        FileUpload fileUpload = new FileUpload();
	        fileUpload.fileUpload();
	    }
}