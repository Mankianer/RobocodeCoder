package de.mankianer.robocodecoder.logic.klassen;

import de.mankianer.robocodecoder.logic.klassen.Exeption.TypePasstNichtExeption;

public class Value extends CodeGenerator{

   public enum Status {
       Error, Init, Use, Set, UseLoad;
   }

    private Type type;

    private String name;

    private Status status;

    private Value load;

    public Value(String load, Type type) {
        this.name = load;
        this.type = type;
        this.status = Status.UseLoad;
    }

    public static Value getInt(int load)
    {
        return new Value("" + load, Type.Primitiv.INT.getType());
    }

    public static Value getDouble(double load)
    {
        return new Value("" + load, Type.Primitiv.DOUBLE.getType());
    }

    public static Value getNull()
    {
        return new Value("null", Type.Primitiv.NULL.getType());
    }

    public static Value getString(String load)
    {
        return new Value(load, Type.Primitiv.STRING.getType());
    }

    public static Value getChar(char load)
    {
        return new Value("" + load, Type.Primitiv.CHAR.getType());
    }

    public void setStatusUse(){
        status = Status.Use;
    }

    public void setStatusInit(Value value) throws TypePasstNichtExeption {
        if(type.isSubType(value.type))
        {
            status = Status.Init;
            load = value;
            addSubGenerator(load);
        }
        else
        {
            throw new TypePasstNichtExeption(this, type, value.type);
        }

    }



    public void setStatusSet(Value value) throws TypePasstNichtExeption {
        if(type.isSubType(value.type))
        {
            status = Status.Set;
            load = value;
            addSubGenerator(load);
        }
        else
        {
            throw new TypePasstNichtExeption(this, type, value.type);
        }
    }

    @Override
    public String createCode() {
        switch (status)
        {
            case Init:
                return type.getName() + " " + name + " = " + ((load.status == Status.Use || load.status == Status.UseLoad) ? load.createCode() : "null");
            case Set:
                return name + " = " + load.name;
            case Use: case UseLoad:
                return name;
        }

        return null;
    }

    @Override
    public boolean isValid() {
        switch (status)
        {
            case Init:
                return type != null && load != null && name != null && !name.isEmpty();
            case Set:
                return load != null && load.status == Status.Use && load.isValid() && type != null && type.isSubType(load.type);
            case Use: case UseLoad:
                return name != null && !name.isEmpty();
            case Error:
                return false;
        }

        return false;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
