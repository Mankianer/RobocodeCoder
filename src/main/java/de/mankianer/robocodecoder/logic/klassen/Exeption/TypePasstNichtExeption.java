package de.mankianer.robocodecoder.logic.klassen.Exeption;

import de.mankianer.robocodecoder.logic.klassen.CodeGenerator;
import de.mankianer.robocodecoder.logic.klassen.PrimitivType;

public class TypePasstNichtExeption extends CodeExeption {

    public TypePasstNichtExeption(CodeGenerator codeGenerator, PrimitivType primitivType1, PrimitivType primitivType2) {
        super(codeGenerator, "PrimitivType: " + primitivType2.getName() + " ist kein Subtyp von " + primitivType1.getName() );
    }
}
