package de.mankianer.robocodecoder.logic.klassen;

import de.mankianer.robocodecoder.logic.klassen.Exeption.TypePasstNichtExeption;

public class Variabel {

    private String name;

    private boolean isInit, isUsed;

    private Value value;
    public Variabel(String name, String load, Type type) {

        this.name = name;
        value = new Value(load, type);
    }

    public Variabel(String name, Value value){
        this.name = name;
        this.value = value;
    }

    public boolean isInit(){
        return isInit;
    }

    public boolean isUsed(){
        return isUsed;
    }

    public Value getCallValue()
    {
        isUsed = true;
        Value ret = new Value(name, value.getType());
        ret.setStatusUse();
        value.addSubGenerator(ret);
        return ret;
    }

    public Value getUseValue()
    {
        isUsed = true;
        Value ret = new Value(value.getName(), value.getType());
        value.addSubGenerator(ret);
        return ret;
    }

    public Value getInitValue(Value value) throws TypePasstNichtExeption {

        isInit = true;
        Value ret = new Value(name, this.value.getType());
        ret.setStatusInit(value);
        value.addSubGenerator(ret);
        return ret;
    }


    public  Value getSetValue(Value value) throws TypePasstNichtExeption {
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
