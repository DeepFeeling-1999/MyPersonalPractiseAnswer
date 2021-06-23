package A.f1.p7;

import java.io.*;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 */
public class t7 {
    public static void main(String[] args) {
        int jAmount = 0, cAmount = 0, iAmount = 0;

        //用的相对路径，将资源文件添加到了项目工程文件中
        //绝对路径只需写全,如D://...
        //另，一般资源文件都和项目文件打包在一起，用相对路径
        File myFile = new File("src\\ideaResources//t3.txt");

        //如果不存在则创建一个
        if (!myFile.exists()) {
            try {
                boolean result = myFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件存在");
            try {
                //FileInputStream myFileInputStream=new FileInputStream(myFile);
                //InputStreamReader inputStreamReader=new InputStreamReader(myFileInputStream);
                char[] c = new char[1024];

                FileReader myReader = new FileReader(myFile);
                int read = myReader.read(c);

                while (read != -1) {
                    //统计数目
                    for (char tempC : c) {
                        if (tempC == 'j') {
                            jAmount++;
                        } else if (tempC == 'c') {
                            cAmount++;
                        } else if (tempC == 'i') {
                            iAmount++;
                        }
                    }

                    //输出到控制台，也可以输出到另一个IO流中
                    System.out.print(new String(c));
                    read = myReader.read(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println();
                System.out.println(
                        "目标文件中一共有 " + jAmount + " 个'j'\n" + "有 " + cAmount + " 个'c'\n" + "有 " + iAmount + " 个'i'\n");
            }
        }
    }
}
