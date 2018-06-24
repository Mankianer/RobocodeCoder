package de.mankianer.robocodecoder.logic.klassen.Exeption;

import de.mankianer.robocodecoder.logic.klassen.CodeGenerator;
import de.mankianer.robocodecoder.logic.klassen.Parameter;

public class ParameterPasstNichtExeption extends CodeExeption {

    private Parameter soureceParameter;

    private Parameter targetParamter;

    public ParameterPasstNichtExeption(CodeGenerator codeGenerator, Parameter soureceParameter, Parameter targetParamter) {

        super(codeGenerator, "Parameter Passen nicht: SourceParameter: " + soureceParameter + " TargetParamter: " + targetParamter );
        this.soureceParameter = soureceParameter;
        this.targetParamter = targetParamter;
    }
    public Parameter getSoureceParameter() {
        return soureceParameter;
    }

    public Parameter getTargetParamter() {
        return targetParamter;
    }
}
