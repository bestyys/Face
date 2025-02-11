package face;
/*
 * 已经不用这个方法了，这个是调用API，需要网络资源，反应速度也相应比较慢。
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.net.ssl.SSLException;

import net.sf.json.JSONObject;

public class FaceRecognition {
	
//	public static void main(String[] args) throws Exception{
//		//file1 and file2 represent the URL of your images.
//        File file1 = new File("D:\\2.jpg");
//        File file2 = new File("D:\\3.jpg");
//		byte[] buff1 = getBytesFromFile(file1);
//		byte[] buff2 = getBytesFromFile(file2);
//		//Request URL
//		String url = "https://api-us.faceplusplus.com/facepp/v3/compare";
//        HashMap<String, String> map = new HashMap<>();
//        HashMap<String, byte[]> byteMap = new HashMap<>();
//        //api_key & api_secret.You can get them from faceplusplus.com
//        map.put("api_key", "mRH0fKaC-tpC-KbRSnOpS8-yAJ7_SUa-");
//        map.put("api_secret", "eSsYzBTRO1gpPdFARMnzZxTrNTO6D6pd");
//        byteMap.put("image_file1", buff1);
//        byteMap.put("image_file2", buff2);
//        try{
//            byte[] bacd = post(url, map, byteMap);
//            String str = new String(bacd);
//            JSONObject json = JSONObject.fromObject(str);
//            String result = json.getString("confidence");
//            
//            System.out.println("这两张图片中人脸的相似度为："+result);
//        }catch (Exception e) {
//        	e.printStackTrace();
//		}
//	}
	
	
	/*
	 * 对比两张人脸调用的方法。
	 * 需要传入的参数有摄像头获得的图像和注册的人脸头像（以存储在计算机上的文件位置给出，参考这个类被注释的main方法里面File）
	*/
	public String Compare(String CameraPath, String RegisterPath ) {
		
		//file1 and file2 represent the URL of your images.
        File file1 = new File(CameraPath);
        File file2 = new File(RegisterPath);
		byte[] buff1 = getBytesFromFile(file1);
		byte[] buff2 = getBytesFromFile(file2);
		//Request URL
		String url = "https://api-us.faceplusplus.com/facepp/v3/compare";
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, byte[]> byteMap = new HashMap<>();
        //api_key & api_secret.You can get them from faceplusplus.com
        map.put("api_key", "mRH0fKaC-tpC-KbRSnOpS8-yAJ7_SUa-");
        map.put("api_secret", "eSsYzBTRO1gpPdFARMnzZxTrNTO6D6pd");
        byteMap.put("image_file1", buff1);
        byteMap.put("image_file2", buff2);
        try{
            byte[] bacd = post(url, map, byteMap);
            String str = new String(bacd);
            JSONObject json = JSONObject.fromObject(str);
            String result = json.getString("confidence");
            return result;
        }catch (Exception e) {
        	e.printStackTrace();
		}
		
		return null;
		
	}
	
	private final static int CONNECT_TIME_OUT = 30000;
    private final static int READ_OUT_TIME = 50000;
    private static String boundaryString = getBoundary();
    protected static byte[] post(String url, HashMap<String, String> map, HashMap<String, byte[]> fileMap) throws Exception {
        HttpURLConnection conne;
        URL url1 = new URL(url);
        conne = (HttpURLConnection) url1.openConnection();
        conne.setDoOutput(true);
        conne.setUseCaches(false);
        conne.setRequestMethod("POST");
        conne.setConnectTimeout(CONNECT_TIME_OUT);
        conne.setReadTimeout(READ_OUT_TIME);
        conne.setRequestProperty("accept", "*/*");
        conne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);
        conne.setRequestProperty("connection", "Keep-Alive");
        conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
        DataOutputStream obos = new DataOutputStream(conne.getOutputStream());
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry) iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            obos.writeBytes("--" + boundaryString + "\r\n");
            obos.writeBytes("Content-Disposition: form-data; name=\"" + key
                    + "\"\r\n");
            obos.writeBytes("\r\n");
            obos.writeBytes(value + "\r\n");
        }
        if(fileMap != null && fileMap.size() > 0){
            Iterator fileIter = fileMap.entrySet().iterator();
            while(fileIter.hasNext()){
                Map.Entry<String, byte[]> fileEntry = (Map.Entry<String, byte[]>) fileIter.next();
                obos.writeBytes("--" + boundaryString + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey()
                        + "\"; filename=\"" + encode(" ") + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.write(fileEntry.getValue());
                obos.writeBytes("\r\n");
            }
        }
        obos.writeBytes("--" + boundaryString + "--" + "\r\n");
        obos.writeBytes("\r\n");
        obos.flush();
        obos.close();
        InputStream ins = null;
        int code = conne.getResponseCode();
        try{
            if(code == 200){
                ins = conne.getInputStream();
            }else{
                ins = conne.getErrorStream();
            }
        }catch (SSLException e){
            e.printStackTrace();
            return new byte[0];
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[4096];
        int len;
        while((len = ins.read(buff)) != -1){
            baos.write(buff, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        ins.close();
        return bytes;
    }
    private static String getBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 32; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
        }
        return sb.toString();
    }
    private static String encode(String value) throws Exception{
        return URLEncoder.encode(value, "UTF-8");
    }
    
    public static byte[] getBytesFromFile(File f) {
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
        }
        return null;
    }

}
