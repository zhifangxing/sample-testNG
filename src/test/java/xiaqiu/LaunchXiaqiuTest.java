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
     porps.put("app", "/Users/zhifang.xing/xiaqiu_v1.4.6_test.apk");
     porps.put("reuse", 1);
//     porps.put("deviceName","L7T4O7UW99999999");
//     porps.put("autoAcceptAlerts", true);
//     porps.put("browserName", "Chrome");
     JSONObject desiredCapabilities = new JSONObject();
     desiredCapabilities.put("desiredCapabilities", porps);
     driver.initDriver(desiredCapabilities);
     
     JSONObject dragJson = JSONObject.parseObject("{fromX:700,fromY:300,toX:10,toY:100,steps:5}");
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
	public void test_case_1() throws Exception{
		
//      登录页面
		 System.err.println("------------#1 login test-------------------");
//		 switchToNative(driver).elementById("et_phone").sendKeys("15811495608"); //转向native页面并定位，该句不好使
//		 switchToNative(driver).elementById("et_pwd").sendKeys("111111");
//		 switchToNative(driver).elementsByClassName("android.widget.EditText").getIndex(1).sendKeys("111111");
		 ElementSelector selector = driver.elementsByClassName("android.widget.EditText");
		 //input username and pwd
		 selector.getIndex(0).sendKeys("15811495608");
		 selector.getIndex(1).sendKeys("111111");
		 //click login button
		 driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]").click();
		 driver.sleep(10000);
		 
		 
		 
	}
	@Test
	public void test_case_2() throws Exception{
		
		System.err.println("------------#2 indexPage test-------------------");
		ElementSelector selector = driver.elementsByClassName("android.widget.Button");
//		Assert.assertEquals(driver.elementByCss(selector.getIndex(0).toString()), "开始借款");
//		Element borrowBtn = driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[15]/android.view.View[1]/android.widget.Button[1]");
//		if (borrowBtn.isDisplayed()) {
//			borrowBtn.click();
//		}else {
//			System.err.println("开始借款按钮未找到");
//			driver.sleep(5000);
//			}
		 driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[15]/android.view.View[1]/android.widget.Button[1]").click();
		 driver.sleep(5000);
		
	}
	
	@Test
	public void test_case_3() throws Exception{
		System.err.println("------------#3 basicInfo test-------------------");
        
	    driver.sleep(10000);
	    
//	    定位到真实姓名输入框
	    ElementSelector selector = driver.elementsByClassName("android.widget.EditText");
	    String username = "邢志芳";
	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[3]/android.widget.EditText[1]")
	    .sendKeys(username);
//	    定位到身份证号输入框
	    String pwd = "411122";
	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]/android.widget.EditText[1]")
	    .sendKeys(pwd+"1987"+"08054643");
	    driver.sleep(3000);
//	    定位到身份证件
	    selector = driver.elementsByClassName("android.view.View");
	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[5]/android.view.View[2]")
	    .click();
//	    System.err.println("------------进入身份证上传页面-------------------");
//	    selector = driver.elementsByClassName("android.widget.ImageView");
//	    Element textFront = driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
//	    if (textFront.isDisplayed()) {
//	    	System.err.println("------------确认已经进入身份证上传页面-------------------");
//		} else {
//			driver.sleep(3000);
//		}
//	    System.err.println("------------上传身份证正面照片-------------------");
	    driver.sleep(3000);
//	    selector = driver.elementsByClassName("android.widget.ImageView");
//	    定位到上传身份证正面框处并点击出现选择照片方式：拍照、相册、取消三种
//	    for (int i = 0; i < selector.size()-1; i++) {
//			System.err.println(selector.getIndex(i));
//		}
//	    selector.getIndex(0).click();//返回了上个页面，推测是左上角按钮
//	    selector.getIndex(1).click();//点击了正面照片框
//	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]").click();
//	    选择相册
//	    selector = driver.elementsByClassName("android.widget.LinearLayout");
//	    for (int i = 0; i < selector.size()-1; i++) {
//	    	System.err.println(selector.getIndex(i));
//	    }
//	    selector.getIndex(2).click();
//	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageView[2]").click();
//	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[2]").click();
	        
	        
//	    进入手机相册
//	    selector = driver.elementsByClassName("android.view.View");
//	    System.err.println(selector.size());
//	    selector.getIndex(1).click();
	        
//	    定位到活体验证字段
	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[6]/android.view.View[2]")
	    .click();
	    
//	    parseObject("{fromX:700,fromY:300,toX:10,toY:100,steps:5}");
	    driver.drag(700,300,700,10,2,5);
	   
	    
//	    下一步按钮高亮，定位并点击进入下个页面
	    selector =  driver.elementsByClassName("android.widget.Button");
	    driver.elementByXPath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[10]/android.widget.Button[1]")
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
