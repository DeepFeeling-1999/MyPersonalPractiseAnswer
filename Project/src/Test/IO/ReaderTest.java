package Test.IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author dell
 */
public class ReaderTest {
    public static void main(String[]args){
        File myFile=new File("src\\ideaResources//test.txt");

        if(!myFile.exists()){
            try{
                myFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("文件存在");
            try{
                //FileInputStream myFileInputStream=new FileInputStream(myFile);
                //InputStreamReader inputStreamReader=new InputStreamReader(myFileInputStream);
                char[]c=new char[1024];

                FileReader myReader=new FileReader(myFile);
                int read=myReader.read(c);
                while(read!=-1){
                    System.out.print(new String(c));
                    read=myReader.read(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
