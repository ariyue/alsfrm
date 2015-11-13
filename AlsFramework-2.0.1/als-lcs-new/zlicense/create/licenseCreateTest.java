package zlicense.create;



public class licenseCreateTest {
	public static void main(String[] args){
		CreateLicense cLicense = new CreateLicense();
		
		cLicense.setParam("d:/license/createAlsParam.properties");
		//
		cLicense.create();
	}
}
