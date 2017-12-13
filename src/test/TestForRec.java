package test;

import camera.JavacvCameraTest01;
import face.FaceMathceByLuxand;
import face.FaceRecognition;

public class TestForRec {
	public static void main(String[] args) throws Exception {
		JavacvCameraTest01 camera = new JavacvCameraTest01();
		String CameraPath=camera.face();
		System.out.println("正在比对。。。");
		String RegisterPath = "D:\\yys.jpg";
		FaceRecognition registerFace = new FaceRecognition();
		String result = registerFace.Compare(CameraPath, RegisterPath);
		
		
//		System.out.println(result);
		if(Float.parseFloat(result)>=60) {
			System.out.println("欢迎您，雨生。");
		}
		else {
			System.out.println("您没有访问权限。。");
		}
				
	}
}
