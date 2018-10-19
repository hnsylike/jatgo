package com.kafang.atgo.restful.unitTest;

import com.alibaba.fastjson.JSONObject;
import com.kafang.atgo.utils.AtgoValidator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * @author xuejian.sun
 */
@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Test
    public void testDoReturnWhen(){
        Properties properties = mock(Properties.class);

        doReturn("x").when(properties).get("ax");

        assertEquals("x",properties.get("ax"));
    }

    @Test
    @Ignore
    public void validate(){
        Demo demo = new Demo(null,2);
        AtgoValidator.initialize(demo).allError().forEach(System.out::println);
        AtgoValidator.initialize(demo).throwFirstError();
    }

    @Test
    public void testFastJson(){
        String json = (String) JSONObject.toJSON(new Demo("s", 3)).toString();
        log.info("{}",json);
    }

    @Data
    public static class Demo implements Serializable {
        @NotNull(message = "不能为空,这个值")
        private String str;

        @Min(value = 3,message = "不能小于3")
        private int num;

        public Demo(String str,int num) {
            this.str = str;
            this.num = num;
        }
    }

}
