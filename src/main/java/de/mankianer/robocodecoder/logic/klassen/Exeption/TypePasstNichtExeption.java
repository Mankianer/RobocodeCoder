package de.mankianer.robocodecoder.logic.klassen.Exeption;

import de.mankianer.robocodecoder.logic.klassen.CodeGenerator;
import de.mankianer.robocodecoder.logic.klassen.Type;

public class TypePasstNichtExeption extends CodeExeption {

    public TypePasstNichtExeption(CodeGenerator codeGenerator, Type type1, Type type2) {
        super(codeGenerator, "PrimitivType: " + type2.getName() + " ist kein Subtyp von " + type1.getName() );
    }
}
