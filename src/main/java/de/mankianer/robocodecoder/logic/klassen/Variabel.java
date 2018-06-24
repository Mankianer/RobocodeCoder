package de.mankianer.robocodecoder.logic.klassen;

import de.mankianer.robocodecoder.logic.klassen.Exeption.TypePasstNichtExeption;

public abstract class Variabel {

    private String name;

    private boolean isInit, isUsed;

    private Value value;
    public Variabel(String name, Type primitivType) {

        this.name = name;
        value = new Value(name, primitivType);
    }

    public boolean isInit(){
        return isInit;
    }

    public boolean isUsed(){
        return isUsed;
    }

    public CodeGenerator getUseValue()
    {
        isUsed = true;
        Value ret = new Value(name, value.getType());
        value.addSubGenerator(ret);
        return ret;
    }

    public CodeGenerator getInitValue(Value value) throws TypePasstNichtExeption {

        isInit = true;
        Value ret = new Value(name, this.value.getType());
        ret.setStatusInit(value);
        value.addSubGenerator(ret);
        return ret;
    }


    public  CodeGenerator getSetValue(Value value) throws TypePasstNichtExeption {
        Value ret = new Value(name, this.value.getType());
        ret.setStatusSet(value);
        value.addSubGenerator(ret);
        return ret;

    }

    public Type getType()
    {
        return value.getType();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Variabel[type=" + value.getType().getName() + "; name=" + name  + "]";
    }
}
