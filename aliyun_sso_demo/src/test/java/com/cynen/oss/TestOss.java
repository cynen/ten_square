package com.cynen.oss;

import com.cynen.oss.utils.OssUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OssApplication.class)
public class TestOss {

    @Autowired
    private OssUtils ossUtils;

    @Test
    public void test(){
        File file = new File("D:\\Pictures\\720\\720\\ship.jpg");
        ossUtils.uploadFile(file);
    }

}
