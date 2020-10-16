package MyThread.PseudoSharing;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/16
 */
public class TestForContent {
    static final int LINE=1024;
    static final int COLUMN=1024;

    public static void main(String[]args){
        long[][]array=new long[LINE][COLUMN];
        long startTime=System.currentTimeMillis();

        for(int i=0;i<LINE;++i){
            for(int j=0;j<COLUMN;++j){
                array[i][j]=i*2+j;
            }
        }
    }
}
