package de.mankianer.robocodecoder.logic.klassen;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Type {

    public enum Primitiv{
        NULL ("null", null),
        INT ("int", NULL.getType()),
        DOUBLE ("double", INT.getType()),
        CHAR ("char", NULL.getType()),
        STRING ("String", CHAR.getType()),
        ;

        Type type;

        private Primitiv(String name, Type ... subtypes) {
            type = new Type(subtypes, name);
        }

        public Type getType() {
            return type;
        }
    };

    private String name;

    private Type[] subTypes;
    private Type(Type[] subTypes, String name) {

        this.name = name;
        this.subTypes = subTypes;
    }

    public Type(String name, Type ... subTypes)
    {
        this(subTypes,name);
        if(subTypes == null || subTypes.length == 0)
        {
            throw new NullPointerException("subType darf nicht leer sein!");
        }
    }

    public boolean isSubType(Type type)
    {
        List<String> allSubTypes = new ArrayList();
        getAllSubtype(allSubTypes);
        return allSubTypes.contains(type.getName());
    }

    private void getAllSubtype(List<String> liste)
    {
        if(!liste.contains(getName())){
            liste.add(getName());
            if(subTypes != null && subTypes.length > 0) {
                for (int i = 0; i < subTypes.length; i++) {
                    subTypes[i].getAllSubtype(liste);
                }
            }
        }
    }

    public String getName() {

        return name;
    }
}
