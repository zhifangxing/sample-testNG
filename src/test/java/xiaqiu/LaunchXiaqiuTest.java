package xiaqiu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.apache.log4j.helpers.SyslogQuietWriter;
import org.testng.Assert;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import macaca.client.MacacaClient;
import macaca.client.commands.Element;
import macaca.client.common.ElementSelector;
import macaca.client.common.Keycode;

public class LaunchXiaqiuTest {
	
	 static MacacaClient driver = new MacacaClient();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 /*
        Desired Capabilities are used to configure webdriver when initiating the session.
        Document URL: https://macacajs.github.io/desired-caps.html
      */
     JSONObject porps = new JSONObject();
     porps.put("platformName", "android");
     porps.put("app", "/Users/zhifang.xing/xiaqiu_v1.4.7_test.apk");
     porps.put("reuse", 1);
//     porps.put("deviceName","L7T4O7UW99999999");
//     porps.put("autoAcceptAlerts", true);
//     porps.put("browserName", "Chrome");
     JSONObject desiredCapabilities = new JSONObject();
     desiredCapabilities.put("desiredCapabilities", porps);
     driver.initDriver(desiredCapabilities);
     
     JSONObject dragJson = JSONObject.parseObject("{fromX:700,fromY:300,toX:10,toY:100,duration:0.2}");
     String startAction = "drag";
     driver.touch(startAction, dragJson)
     .sleep(1000)
     .touch(startAction, dragJson)
     .sleep(1000);
     driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.Button[1]")
     .click();
     driver.sleep(5000);
     
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	
	@Test
	public void login_test() throws Exception{
		
//      登录页面
		 System.err.println("------------#1 login test-------------------");
		 ElementSelector selector = driver.elementsByClassName("android.widget.EditText");
		 //input username and pwd
		 selector.getIndex(0).sendKeys("15811495608");
		 selector.getIndex(1).sendKeys("111111");
		 //click login button
		 driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]").click();
		 driver.sleep(10000);
		 
		 
		 
	}
	@Test
	public void indexPage_test() throws Exception{
		
		System.err.println("------------#2 indexPage test-------------------");
		driver.drag(700,300,700,10,2,5);
		ElementSelector selector = driver.elementsByClassName("android.widget.Button");
		driver.sleep(10000);
		driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[15]/android.view.View[1]/android.widget.Button[1]").click();
		driver.sleep(5000);
		
	}
	
	@Test
	public void baseInfo_test() throws Exception{
		System.err.println("------------#3 basicInfo test-------------------");
	    driver.sleep(10000);
//	    定位到真实姓名输入框
	    ElementSelector selector = driver.elementsByClassName("android.widget.EditText");
	    driver.sleep(3000);
	    String username = "邢志芳";
	    driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.widget.EditText[1]").sendKeys(username);
//	    定位到身份证号输入框
//	    String pwd = "411122";
	     
//	    JSONObject porps = new JSONObject();
//	    porps.put("IDNumber", "411122198708054643");
//	    System.err.println(porps.getString("IDNumber"));
	    driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[1]").sendKeys("411122198708054643");
//	    .sendKeys(porps.getString("IDNumber").toString());
//	    driver.keys(porps.getString("IDNumber").toString());
	   
//	    .sendKeys(pwd+"198708"+"054643");
	    
	    driver.sleep(5000);
//	    定位到身份证件
	    selector = driver.elementsByClassName("android.view.View");
	    driver.sleep(2000);
	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]/android.view.View[2]")
	    .click();
	    driver.sleep(3000);
	        
//	    定位到活体验证字段
	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[6]/android.view.View[2]")
	    .click();
	    
//	    parseObject("{fromX:700,fromY:300,toX:10,toY:100,steps:5}");
	    driver.drag(700,300,700,10,2,1);
	    driver.sleep(5000);
	    
//	    下一步按钮高亮，定位并点击进入下个页面
	    selector =  driver.elementsByClassName("android.widget.Button");
	    driver.sleep(5000);
	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.widget.Button[1]")
	    .click();
	}
	
	@Test
	public void bankInfo_test() throws Exception{

//		进入银行卡信息页面
        System.err.println("------------#4 bankinfo test-------------------");
        driver.sleep(10000);
        ElementSelector selector = driver.elementsByClassName("android.view.View");
        driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[4]")
        .click();
        
//        出现银行选择框
        selector = driver.elementsByClassName("android.widget.LinearLayout");
        driver.sleep(2000);
//        选择民生银行
        driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[6]")
        .click();
//        准备输入银行卡号
        selector = driver.elementsByClassName("android.widget.EditText");
        String bankNum = "6226220128734836"; 
        driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[5]/android.widget.EditText[1]")
        .sendKeys(bankNum);
//        准备输入手机号
        String phoneNum = "15811495608";
        driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[6]/android.widget.EditText[1]")
		.sendKeys(phoneNum);
//        上传银行卡照片
        selector = driver.elementsByClassName("android.view.View");
        driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[8]")
        .click();
        driver.sleep(3000);
//        下一步按钮高亮，点击进入完善信息页面
        selector = driver.elementsByClassName("android.widget.Button");
        driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[13]/")
        .click();
	}
	
	public void ReqExtendInfo_test() throws Exception{
		

//		进入完善信息页面
        System.err.println("------------#4 reqExtendInfo test-------------------");
//        定位到住房状况
        ElementSelector selector = driver.elementsByClassName("android.view.View");
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]")
       .click();
//       选择租房状况，租房
       selector = driver.elementsByClassName("android.widget.TextView");
       driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
       .click();
//       定位到住宅地址
       selector = driver.elementsByClassName("android.view.view");
       driver.elementByXPath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[3]")
       .click();
//       选择城市北京  北京市  朝阳
       selector = driver.elementsByClassName("android.widget.TextView");
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.TextView[3]")
       .click();
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.TextView[1]")
       .click();
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.TextView[2]")
       .click();
//      定位住宅的详细地址
       selector = driver.elementsByClassName("android.widget.EditText"); 
       String houseAddress = "八里庄北里1号院";
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[1]")
       .sendKeys(houseAddress);
//       定位职业信息--单位名称
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[5]/android.widget.EditText[1]")
       .sendKeys("百融金服");
//       定位到职业信息--单位地址
       selector = driver.elementsByClassName("android.view.view");
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[6]")
       .click();
//       选择单位地址：北京 北京市 朝阳区
       selector = driver.elementsByClassName("android.widget.TextView");
       driver.elementByXPath(" //android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.TextView[3]")
       .click();
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.TextView[1]")
       .click();
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.TextView[2]")
       .click();
       selector = driver.elementsByClassName("android.widget.EditText"); 
       String companyAddress = "中关村南三街";
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]")
       .sendKeys(companyAddress);
//       定位到单位电话
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[7]/android.widget.EditText[1]")
       .sendKeys("010");
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[7]/android.widget.EditText[2]")
       .sendKeys("12345678");
//       定位到紧急联系人
       String name = "小丁";
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[9]/android.widget.EditText[1]")
       .sendKeys(name);
       String namePhoneNum = "13501322044";
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[10]/android.widget.EditText[1]")
       .sendKeys(namePhoneNum);
//       定位到关系
       selector = driver.elementsByClassName("android.view.view");
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[11]")
       .click();
//       选择兄弟姐妹
       selector = driver.elementsByClassName("android.widget.TextView");
       driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")
       .click();
//       下一步按钮高亮
       selector = driver.elementsByClassName("android.widget.Button");
       driver.elementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[15]/android.widget.Button[1]")
       .click();
       
	}

	
	 // switch to the context of the last pushed webview
	    public MacacaClient switchToWebView(MacacaClient driver) throws Exception {
	        JSONArray contexts = driver.contexts();
	        return driver.context(contexts.get(contexts.size() - 1).toString());
	    }

	    // switch to the context of native
	    public MacacaClient switchToNative(MacacaClient driver) throws Exception {
	        JSONArray contexts = driver.contexts();
	        return driver.context(contexts.get(0).toString());
	    }

}
