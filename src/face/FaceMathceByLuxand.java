package face;

import Luxand.FSDK;
import Luxand.FSDK.HImage;

public class FaceMathceByLuxand {
	
	//Method to compare two images;
	//这个方法只是用来对比两张图片的，返回一个布尔型的flag
	//阈值是一个特别的方法算出来的，所以需要更改阈值的需要在这个方法内部完成。
	
	public boolean match(String CameraPath, String RegisterPath) {
		FSDK.ActivateLibrary("CAwCJi73pkR/CC3UB/93EaatUU/baK3FOmII4WrfCAlBktFeua2dwWICwEoQbZvN5Z8V4rFx8QMXG2u1FAHk9bV1pwKhGCl2iTeHO9OIUexF7JavtZxFRHGDRHRu1kj+1PiC+QXLLWQErwHP+4H33Z1UnB6OKyiDcw6G/TSV3cg=");
		
		HImage img1 = new HImage();
		HImage img2 = new HImage();
		FSDK.Initialize();
		//Test successfully of loading image.
		int a = FSDK.LoadImageFromFile(img1, CameraPath); 
		FSDK.LoadImageFromFile(img2, RegisterPath); 
		
		FSDK.FSDK_FaceTemplate.ByReference FaceTemplate1 = new FSDK.FSDK_FaceTemplate.ByReference();
		FSDK.FSDK_FaceTemplate.ByReference FaceTemplate2 = new FSDK.FSDK_FaceTemplate.ByReference();
		FSDK.GetFaceTemplate(img1, FaceTemplate1);
		FSDK.GetFaceTemplate(img2, FaceTemplate2);
		//FRRValue - the desired FRR value. Varies from 0.0 (means 0%) to 1.0 (means 100%). 
		float FRRValue=0.9f;
		float[] Threshold = new float[1];
		FSDK.GetMatchingThresholdAtFRR(FRRValue, Threshold);
		
		float Similarity[] = new float[1];
		FSDK.MatchFaces(FaceTemplate1, FaceTemplate2, Similarity);
		
		boolean flag = false;
		if(Similarity[0]>Threshold[0]) {
			flag = true;
		}
		else {
			flag = false;
		}
		
		return flag;
	}
}
