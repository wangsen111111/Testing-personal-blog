package dao.login;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class LoginTest {

    /**
     * 测试登录接口，账号为：正确的用户名和密码
     */
    @Test
    public void LoginTest() throws IOException {
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/xw/login?username=xw&password=123");
        HttpClient client = new DefaultHttpClient();
        HttpResponse execute = client.execute(httpGet);
        Assert.assertEquals(200,execute.getStatusLine().getStatusCode());
    }

    /**
     * 测试登录接口，账号为：不传账号和密码
     */
    @Test
    public void LoginTest1() throws IOException {
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/xw/login");
        HttpClient client = new DefaultHttpClient();
        HttpResponse execute = client.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        byte[] bys = new byte[1024];
        entity.getContent().read(bys);
        String s = new String(bys);
        String[] split = s.split(":");
        String[] split1 = split[split.length - 1].split("}");
//        System.out.println(split1[0]);
        Assert.assertEquals(split1[0],"-1");

    }
}
