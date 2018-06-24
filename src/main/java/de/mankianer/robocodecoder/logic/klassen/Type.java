package de.mankianer.robocodecoder.logic.klassen;

import java.util.ArrayList;
import java.util.List;

public class Type {

    private String name;

    private Type[] subTypes;
    public Type(String name, Type ... subTypes) {

        this.name = name;
        this.subTypes = subTypes;
    }

    public boolean isSubType(Type type)
    {
        List<String> allSubTypes = new ArrayList();
        getAllSubtype(allSubTypes,this);

        return allSubTypes.contains(type.getName());
    }

    private static void getAllSubtype(List<String> liste, Type subType)
    {
        if(!liste.contains(subType.getName())){
            liste.add(subType.getName());
            for (int i = 0; i < subType.subTypes.length; i++) {
                getAllSubtype(liste, subType);
            }
        }
    }

    public String getName() {

        return name;
    }
}
