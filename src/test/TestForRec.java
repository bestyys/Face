package test;

import camera.JavacvCameraTest01;
import face.FaceMathceByLuxand;
import face.FaceRecognition;

public class TestForRec {
	public static void main(String[] args) throws Exception {
		JavacvCameraTest01 camera = new JavacvCameraTest01();
		String CameraPath=camera.face();
		System.out.println("���ڱȶԡ�����");
		String RegisterPath = "D:\\yys.jpg";
		FaceRecognition registerFace = new FaceRecognition();
		String result = registerFace.Compare(CameraPath, RegisterPath);
		
		
//		System.out.println(result);
		if(Float.parseFloat(result)>=60) {
			System.out.println("��ӭ����������");
		}
		else {
			System.out.println("��û�з���Ȩ�ޡ���");
		}
				
	}
}
