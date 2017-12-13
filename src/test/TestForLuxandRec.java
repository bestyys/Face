package test;
/*
 * 现在的关键是活体检测算法。已经有相关素材，还不清楚可行性。
 */
import camera.JavacvCameraTest01;
import face.FaceMathceByLuxand;

public class TestForLuxandRec {
	public static void main(String[] args) {
		JavacvCameraTest01 camera = new JavacvCameraTest01();
		String CameraPath;
		try {
			CameraPath = camera.face();
			FaceMathceByLuxand faceMathceByLuxand = new FaceMathceByLuxand();
			String RegisterPath = "D:\\yys.jpg";
			boolean flag = faceMathceByLuxand.match(CameraPath, RegisterPath);
			if(flag == true) {
				System.out.println("欢迎你，雨生！");
			}
			else {
				System.out.println("您没有访问权限！");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
