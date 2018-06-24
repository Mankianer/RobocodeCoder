package de.mankianer.robocodecoder.logic.klassen;

import java.util.ArrayList;

public abstract class CodeGenerator {

    private ArrayList<CodeGenerator> subGeneratoren;

    private boolean isRemoved;

    public CodeGenerator() {
        subGeneratoren = new ArrayList<>();
    }

    public void addSubGenerator(CodeGenerator codeGenerator)
    {
        subGeneratoren.add(codeGenerator);
    }

    public boolean removeSubGenerator(CodeGenerator codeGenerator)
    {
        return  subGeneratoren.remove(codeGenerator);
    }

    public void remove()
    {
        isRemoved = true;
        subGeneratoren.forEach(codeGenerator -> remove());
        subGeneratoren.clear();
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public abstract String createCode();

    public abstract boolean isValid();
}
