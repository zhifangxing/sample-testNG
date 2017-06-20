package macaca.client;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import static org.hamcrest.CoreMatchers.containsString;

public class H5SampleTest {
    MacacaClient driver = new MacacaClient();

    @BeforeClass 
    public void setUp() throws Exception {
        // platform: android or ios
        String platform = "android";

        /*
           Desired Capabilities are used to configure webdriver when initiating the session.
           Document URL: https://macacajs.github.io/desired-caps.html
         */
        JSONObject porps = new JSONObject();
        porps.put("platformName", platform);
        porps.put("browserName", "Chrome");
        JSONObject desiredCapabilities = new JSONObject();
        desiredCapabilities.put("desiredCapabilities", porps);
        driver.initDriver(desiredCapabilities);
    }

    @Test 
    public void test_case_1() throws Exception {

        System.out.println("------------#1 h5 web test-------------------");

        driver.get("http://www.baidu.com");
        driver.elementById("index-kw").sendKeys("macaca");
        driver.elementById("index-bn").click();
        driver.sleep(5000);
        String source = driver.source();
        Assert.assertEquals(source, containsString("macaca"));
    }

    @AfterClass 
    public void tearDown() throws Exception {
        driver.quit();
    }
}
