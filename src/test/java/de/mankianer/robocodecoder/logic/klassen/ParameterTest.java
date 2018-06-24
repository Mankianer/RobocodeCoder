package de.mankianer.robocodecoder.logic.klassen;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParameterTest {

    @Test
    public void testParameter(){

        //Emtpty Test
        //Match
        Parameter parEmpty = new Parameter();
        Assert.assertTrue(parEmpty.isMatch(parEmpty));
        Parameter parEmpty2 = new Parameter();
        Assert.assertTrue(parEmpty2.isMatch(parEmpty2));
        Assert.assertTrue(parEmpty.isMatch(parEmpty2));
        Assert.assertTrue(parEmpty2.isMatch(parEmpty));
        //Code
        Assert.assertEquals("", parEmpty.getMathodParameter().createCode());
        Assert.assertEquals("", parEmpty2.getMathodParameter().createCode());
        Assert.assertEquals("", parEmpty.getCallParameter(parEmpty).createCode());
        Assert.assertEquals("", parEmpty2.getCallParameter(parEmpty2).createCode());
        Assert.assertEquals("", parEmpty.getCallParameter(parEmpty2).createCode());
        Assert.assertEquals("", parEmpty2.getCallParameter(parEmpty).createCode());

        //OneType
        //Match
        Parameter parInt = new Parameter(new Variabel("varInt", Value.getInt(-3)));
        Assert.assertTrue(parInt.isMatch(parInt));
        Parameter parDouble = new Parameter(new Variabel("varDouble", Value.getDouble(-4)));
        Assert.assertTrue(parDouble.isMatch(parDouble));
        Assert.assertTrue(parInt.isMatch(parDouble));
        Assert.assertFalse(parDouble.isMatch(parInt));
        //Code
        Assert.assertEquals("int varInt", parInt.getMathodParameter().createCode());
        Assert.assertEquals("double varDouble", parDouble.getMathodParameter().createCode());
        Assert.assertEquals("varInt", parInt.getCallParameter(parInt).createCode());
        Assert.assertEquals("varDouble", parDouble.getCallParameter(parDouble).createCode());
        Assert.assertEquals("varInt", parInt.getCallParameter(parDouble).createCode());
        Assert.assertFalse(parDouble.getCallParameter(parInt).isValid());

        //TwoType
        //Match
        Parameter parIntInt = new Parameter(new Variabel("varInt", Value.getInt(-3)),new Variabel("varInt2", Value.getInt(-3)));
        Assert.assertTrue(parIntInt.isMatch(parIntInt));
        Parameter parDoubleDouble = new Parameter(new Variabel("varDouble", Value.getDouble(-4)),new Variabel("varDouble2", Value.getDouble(-4)));
        Assert.assertTrue(parIntInt.isMatch(parDoubleDouble));
        Assert.assertTrue(parIntInt.isMatch(parDoubleDouble));
        Assert.assertFalse(parDoubleDouble.isMatch(parIntInt));
        //Code
        Assert.assertEquals("int varInt, int varInt2", parIntInt.getMathodParameter().createCode());
        Assert.assertEquals("double varDouble, double varDouble2", parDoubleDouble.getMathodParameter().createCode());
        Assert.assertEquals("varInt, varInt2", parIntInt.getCallParameter(parIntInt).createCode());
        Assert.assertEquals("varDouble, varDouble2", parDoubleDouble.getCallParameter(parDoubleDouble).createCode());
        Assert.assertEquals("varInt, varInt2", parIntInt.getCallParameter(parDoubleDouble).createCode());
        Assert.assertFalse(parDoubleDouble.getCallParameter(parIntInt).isValid());
    }
}
