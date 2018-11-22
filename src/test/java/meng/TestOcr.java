package meng;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.formula.functions.MinaMaxa;
import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.baidu.aip.ocr.AipOcr;

import oracle.net.aso.i;


public class TestOcr {
	// 设置APPID/AK/SK
	public static final String APP_ID = "11372579";
	public static final String API_KEY = "Y0kr66rbvwciuTHhGBpGzAtY";
	public static final String SECRET_KEY = "bmmCsI69Tu1yT4UnWXyIVbR8zPHFbfrP";
	private static final AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
    public static void main(String[] args) {
    	TestOcr testOcr=new TestOcr();
    	//testOcr.sample(client);
    	//testOcr.sampleBasicGeneral(client);
    	String path="D:\\split\\results";
    	File file=new File(path);
    	File[] files=file.listFiles();
    	long beginTime=System.currentTimeMillis();
    	for(int i=0;i<files.length;i++) {
    		File fil=files[i];
    		String pathname=fil.getPath();
    		System.err.println(i+":"+pathname);
    		testOcr.sampleBasicGeneral(client, pathname);
    	}
    	long endTime=System.currentTimeMillis();
    	System.err.println("用时："+(endTime-beginTime));
        
    }
    public void sample(AipOcr client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        // 参数为本地图片路径
        String image = "D:\\split\\source\\Image_00001.jpg";
        JSONObject res = client.tableRecognitionAsync(image, options);
        HashMap<String, String> option = new HashMap<String, String>();
        option.put("result_type", "json");
        JSONArray jsonArray =res.getJSONArray("result");
        String requestId =jsonArray.getJSONObject(0).get("request_id").toString();
        JSONObject ress = client.tableResultGet("11372579_358232", option);
        JSONObject jsonObj=ress.getJSONObject("result");
        String stringObj=jsonObj.getString("result_data");
        JSONObject josnObje=new JSONObject(stringObj);
        JSONArray jsonArra=josnObje.getJSONArray("forms");
        JSONArray jsonA=jsonArra.getJSONObject(0).getJSONArray("body");
        for(int i=0;i<jsonA.length();i++) {
        	System.out.println(jsonA.getJSONObject(i).get("row"));
        	System.out.println(jsonA.getJSONObject(i).get("column"));
        	System.out.println(jsonA.getJSONObject(i).get("word"));
        }
    }
	public void sampleBasicGeneral(AipOcr client,String pathname) {
    	 HashMap<String, String> options = new HashMap<String, String>();
         options.put("language_type", "CHN_ENG");
          options.put("detect_direction", "true");
          options.put("detect_language", "true");
          options.put("probability", "true");
          // 调用接口
          String image  = pathname;
          JSONObject res = client.basicAccurateGeneral(image, options);
          System.out.println(res.toString(0));
          System.out.println("识别结束");
    }

}
