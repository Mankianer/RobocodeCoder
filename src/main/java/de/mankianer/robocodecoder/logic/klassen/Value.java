package de.mankianer.robocodecoder.logic.klassen;

import de.mankianer.robocodecoder.logic.klassen.Exeption.TypePasstNichtExeption;

public class Value extends CodeGenerator{

   public enum Status {
       Error, Init, Use, Set, UseLoad;
   }

    private PrimitivType primitivType;

    private String name;

    private Status status;

    private Value load;

    public Value(String load, PrimitivType primitivType) {
        this.name = load;
        this.primitivType = primitivType;
        this.status = Status.UseLoad;
    }

    public void setStatusUse(){
        status = Status.Use;
    }

    public void setStatusInit(Value value) throws TypePasstNichtExeption {
        if(primitivType.isSubType(value.primitivType))
        {
            status = Status.Init;
            load = value;
            addSubGenerator(load);
        }
        else
        {
            throw new TypePasstNichtExeption(this, primitivType, value.primitivType);
        }

    }

    public void setStatusSet(Value value) throws TypePasstNichtExeption {
        if(primitivType.isSubType(value.primitivType))
        {
            status = Status.Set;
            load = value;
            addSubGenerator(load);
        }
        else
        {
            throw new TypePasstNichtExeption(this, primitivType, value.primitivType);
        }
    }

    @Override
    public String createCode() {
        switch (status)
        {
            case Init:
                return primitivType.getName() + " " + name + " = " + ((load.status == Status.Use) ? load.createCode() : "null") + ";";
            case Set:
                return name + " = " + load.name + ";";
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
                return primitivType != null && load != null && name != null && !name.isEmpty();
            case Set:
                return load != null && load.status == Status.Use && load.isValid() && primitivType != null && primitivType.isSubType(load.primitivType);
            case Use:
                return name != null && !name.isEmpty();
            case Error:
                return false;
        }

        return false;
    }

    public PrimitivType getPrimitivType() {
        return primitivType;
    }
}
