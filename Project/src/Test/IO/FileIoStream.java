package Test.IO;

import java.io.*;

/**
 * @author dell
 */
public class FileIoStream {
    public static void main(String[]args) throws IOException {
        File myFile=new File("src\\ideaResources//t3.txt");

        if(!myFile.exists()){
            try{
                myFile.createNewFile();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("文件已存在");

            //按一次一kb进行输入
            byte[]bytes=new byte[1024];

            try{
                FileInputStream myFileInputStream=new FileInputStream(myFile);
                FileOutputStream myFileOutputStream=new FileOutputStream("src\\ideaResources//out_test.txt",true);

                //读取到bytes里
                int read=myFileInputStream.read(bytes);
                while(read!=-1){
                    String s=new String(bytes);

                    System.out.print(s+"***"+read);
                    read=myFileInputStream.read(bytes);
                }

                //将bytes写入到输出流中
                myFileOutputStream.write(bytes);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
