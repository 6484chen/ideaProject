package test0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName URLTest
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/21 11:35
 * @Version 1.0
 */
public class URLTest {
    public static void main(String[] args) {
        URL url;
        {
            try {
                url = new URL("https://blog.csdn.net/tigerisland45/article/details/78420636");
                URLConnection urlConnection =url.openConnection();
                System.out.println(urlConnection.getDate());
                System.out.println(urlConnection.getContentLength());
                System.out.println(urlConnection.getContentEncoding());
                //System.out.println(urlConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String msg;
                while ((msg = bufferedReader.readLine())!=null){
                    //String str = new String(msg,0,msg.length(),"gzip");
                    System.out.println(msg);

                }



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
