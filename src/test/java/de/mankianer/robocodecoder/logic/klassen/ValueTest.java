package de.mankianer.robocodecoder.logic.klassen;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValueTest {

    @Test
    public void primitivInput()
    {
        Value valueNULL = new Value("null", Type.Primitiv.NULL.getType());
        Assert.assertTrue(valueNULL.isValid());
        Assert.assertEquals("null",valueNULL.createCode());

        Value valueINT = new Value("1", Type.Primitiv.INT.getType());
        Assert.assertTrue(valueINT.isValid());
        Assert.assertEquals("1",valueINT.createCode());

        Value valueSTRING = new Value("TEST1234", Type.Primitiv.STRING.getType());
        Assert.assertTrue(valueSTRING.isValid());
        Assert.assertEquals("TEST1234",valueSTRING.createCode());
    }
}
