package test;
/*
 * ���ڵĹؼ��ǻ������㷨���Ѿ�������زģ�������������ԡ�
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
				System.out.println("��ӭ�㣬������");
			}
			else {
				System.out.println("��û�з���Ȩ�ޣ�");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
