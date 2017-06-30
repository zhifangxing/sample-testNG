package xiaqiu;

import com.alibaba.fastjson.JSONObject;

public class Test {
	
	public static void getKeyAndValue(){
		JSONObject porps = new JSONObject();
	    porps.put("IDNumber", "411122198708054643");
	    System.err.println(porps.getString("IDNumber"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getKeyAndValue();

	}

}
