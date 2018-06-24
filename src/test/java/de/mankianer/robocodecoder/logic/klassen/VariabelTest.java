package de.mankianer.robocodecoder.logic.klassen;

import de.mankianer.robocodecoder.logic.klassen.Exeption.TypePasstNichtExeption;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VariabelTest {

    @Test
    public void test() throws TypePasstNichtExeption {
        //UseLoad Test
        Variabel varNull = new Variabel("var", Value.getNull());
        Assert.assertEquals("null",varNull.getUseValue().createCode());

        Variabel varInt = new Variabel("var", Value.getInt(10));
        Assert.assertEquals("10",varInt.getUseValue().createCode());

        Variabel varDouble = new Variabel("var", Value.getDouble(10));
        Assert.assertEquals("10.0",varDouble.getUseValue().createCode());

        Variabel varChar = new Variabel("var", Value.getChar('t'));
        Assert.assertEquals("t",varChar.getUseValue().createCode());

        Variabel varString = new Variabel("var", Value.getString("test"));
        Assert.assertEquals("test",varString.getUseValue().createCode());

        Variabel varObject = new Variabel("var", new Value("new Object()", new Type("Object", Type.Primitiv.INT.getType(), Type.Primitiv.STRING.getType(), Type.Primitiv.CHAR.getType()) ));
        Assert.assertEquals("new Object()",varObject.getUseValue().createCode());

        //Call test
        Assert.assertEquals("var",varNull.getCallValue().createCode());
        Assert.assertEquals("var",varInt.getCallValue().createCode());
        Assert.assertEquals("var",varDouble.getCallValue().createCode());
        Assert.assertEquals("var",varChar.getCallValue().createCode());
        Assert.assertEquals("var",varString.getCallValue().createCode());
        Assert.assertEquals("var",varString.getCallValue().createCode());

        //Set test ba Call
        Variabel varNull2 = new Variabel("var2", Value.getNull());
        Assert.assertEquals("var = var2", varNull.getSetValue(varNull2.getCallValue()).createCode());

        Variabel varInt2 = new Variabel("var2", Value.getInt(10));
        Assert.assertEquals("var = var2", varInt.getSetValue(varInt2.getCallValue()).createCode());

        Variabel varDouble2 = new Variabel("var2", Value.getDouble(10));
        Assert.assertEquals("var = var2", varDouble.getSetValue(varDouble2.getCallValue()).createCode());

        Variabel varChar2 = new Variabel("var2", Value.getChar('t'));
        Assert.assertEquals("var = var2", varChar.getSetValue(varChar2.getCallValue()).createCode());

        Variabel varString2 = new Variabel("var2", Value.getString("test"));
        Assert.assertEquals("var = var2", varString.getSetValue(varString2.getCallValue()).createCode());

        Variabel varObject2 = new Variabel("var2", new Value("new Object()", new Type("Object", Type.Primitiv.INT.getType(), Type.Primitiv.STRING.getType(), Type.Primitiv.CHAR.getType()) ));
        Assert.assertEquals("var = var2", varObject.getSetValue(varObject2.getCallValue()).createCode());

        //Set test by UseLoad
        Assert.assertEquals("var = null", varNull.getSetValue(varNull2.getUseValue()).createCode());
        Assert.assertEquals("var = 10", varInt.getSetValue(varInt2.getUseValue()).createCode());
        Assert.assertEquals("var = 10.0", varDouble.getSetValue(varDouble2.getUseValue()).createCode());
        Assert.assertEquals("var = t", varChar.getSetValue(varChar2.getUseValue()).createCode());
        Assert.assertEquals("var = test", varString.getSetValue(varString2.getUseValue()).createCode());
        Assert.assertEquals("var = new Object()", varObject.getSetValue(varObject2.getUseValue()).createCode());

        //Init Test by Call
        Assert.assertEquals("null var = var2", varNull.getInitValue(varNull2.getCallValue()).createCode());
        Assert.assertEquals("int var = var2", varInt.getInitValue(varInt2.getCallValue()).createCode());
        Assert.assertEquals("double var = var2", varDouble.getInitValue(varDouble2.getCallValue()).createCode());
        Assert.assertEquals("char var = var2", varChar.getInitValue(varChar2.getCallValue()).createCode());
        Assert.assertEquals("String var = var2", varString.getInitValue(varString2.getCallValue()).createCode());
        Assert.assertEquals("Object var = var2", varObject.getInitValue(varObject2.getCallValue()).createCode());

        //Init Test by UseLoad
        Assert.assertEquals("null var = null", varNull.getInitValue(varNull2.getUseValue()).createCode());
        Assert.assertEquals("int var = 10", varInt.getInitValue(varInt2.getUseValue()).createCode());
        Assert.assertEquals("double var = 10.0", varDouble.getInitValue(varDouble2.getUseValue()).createCode());
        Assert.assertEquals("char var = t", varChar.getInitValue(varChar2.getUseValue()).createCode());
        Assert.assertEquals("String var = test", varString.getInitValue(varString2.getUseValue()).createCode());
        Assert.assertEquals("Object var = new Object()", varObject.getInitValue(varObject2.getUseValue()).createCode());
    }
}
