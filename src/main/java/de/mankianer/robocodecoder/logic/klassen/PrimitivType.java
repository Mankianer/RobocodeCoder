package de.mankianer.robocodecoder.logic.klassen;

public enum PrimitivType {
    INT ("int",SubType.INT),
    DOUBLE ("double",SubType.DOUBLE, SubType.INT),
    STRING ("String",SubType.STRING),
    NULL (""),
    ;
    private String name;
    private SubType[] subTypes;

    PrimitivType(String name, SubType... subTypes) {
        this.name = name;
        this.subTypes = subTypes;
    }

    public String getName()
    {
        return name;
    }

    public boolean isSubType(PrimitivType primitivType)
    {
        if(primitivType == this) return true;

        for (SubType subType: subTypes ) {
            if(subType != null && subType.primitivType.equals(primitivType))
            {
                return true;
            }
        }
        return false;
    }


    public enum SubType
    {
        INT (PrimitivType.INT),
        DOUBLE (PrimitivType.DOUBLE),
        STRING (PrimitivType.STRING),
        ;
        private final PrimitivType primitivType;

        SubType(PrimitivType primitivType) {
            this.primitivType = primitivType;
        }
    }

    @Override
    public String toString() {
        return "PrimitivType[" + name + "]";
    }
}
