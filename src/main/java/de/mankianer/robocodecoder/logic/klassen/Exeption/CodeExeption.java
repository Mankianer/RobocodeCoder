package de.mankianer.robocodecoder.logic.klassen.Exeption;

import de.mankianer.robocodecoder.logic.klassen.CodeGenerator;

public class CodeExeption extends Exception {

    private CodeGenerator codeGenerator;

    public CodeExeption(CodeGenerator codeGenerator, String msg) {
        super(msg);
        this.codeGenerator = codeGenerator;
    }

    public CodeGenerator getCodeGenerator() {
        return codeGenerator;
    }
}
