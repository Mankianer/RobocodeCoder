package de.mankianer.robocodecoder.logic.klassen;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TypeTest {

    @Test
    public void typeIsSubtypeTest() {
        Assert.assertTrue(Type.Primitiv.DOUBLE.getType().isSubType(Type.Primitiv.DOUBLE.getType()));
        Assert.assertTrue(Type.Primitiv.DOUBLE.getType().isSubType(Type.Primitiv.INT.getType()));
        Assert.assertTrue(Type.Primitiv.DOUBLE.getType().isSubType(Type.Primitiv.NULL.getType()));
        Assert.assertTrue(Type.Primitiv.INT.getType().isSubType(Type.Primitiv.NULL.getType()));
        Assert.assertTrue(Type.Primitiv.INT.getType().isSubType(Type.Primitiv.INT.getType()));
        Assert.assertTrue(Type.Primitiv.NULL.getType().isSubType(Type.Primitiv.NULL.getType()));
        Assert.assertTrue(Type.Primitiv.STRING.getType().isSubType(Type.Primitiv.CHAR.getType()));
        Assert.assertTrue(Type.Primitiv.CHAR.getType().isSubType(Type.Primitiv.CHAR.getType()));
        Assert.assertTrue(Type.Primitiv.STRING.getType().isSubType(Type.Primitiv.NULL.getType()));
        Assert.assertTrue(Type.Primitiv.STRING.getType().isSubType(Type.Primitiv.STRING.getType()));

        Assert.assertFalse(Type.Primitiv.NULL.getType().isSubType(Type.Primitiv.INT.getType()));
        Assert.assertFalse(Type.Primitiv.NULL.getType().isSubType(Type.Primitiv.DOUBLE.getType()));
        Assert.assertFalse(Type.Primitiv.NULL.getType().isSubType(Type.Primitiv.STRING.getType()));
        Assert.assertFalse(Type.Primitiv.NULL.getType().isSubType(Type.Primitiv.CHAR.getType()));
        Assert.assertFalse(Type.Primitiv.INT.getType().isSubType(Type.Primitiv.DOUBLE.getType()));
        Assert.assertFalse(Type.Primitiv.INT.getType().isSubType(Type.Primitiv.STRING.getType()));

        Type ultimate = new Type("Ulti", Type.Primitiv.DOUBLE.getType(),Type.Primitiv.STRING.getType());

        Assert.assertTrue(ultimate.isSubType(Type.Primitiv.STRING.getType()));
        Assert.assertTrue(ultimate.isSubType(Type.Primitiv.DOUBLE.getType()));
        Assert.assertTrue(ultimate.isSubType(Type.Primitiv.NULL.getType()));
        Assert.assertTrue(ultimate.isSubType(Type.Primitiv.INT.getType()));
        Assert.assertTrue(ultimate.isSubType(Type.Primitiv.CHAR.getType()));
        Assert.assertTrue(ultimate.isSubType(ultimate));
    }
}
