package de.mankianer.robocodecoder.logic.klassen;

import java.util.Arrays;

public class Parameter {

    private Variabel[] values;

    public Parameter(Variabel ... values) {

        this.values = values;
    }

    public boolean isMatch(Parameter targetParameter)
    {
        if(values.length == targetParameter.getValues().length)
        {
            for (int i = 0; i < values.length; i++) {
                if(!targetParameter.getValues()[i].getType().isSubType(values[i].getType()))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public CodeGenerator getCallParameter(Parameter targetParameter)
    {
        return new CodeGenerator() {
            @Override
            public String createCode() {
                String ret = "";
                for (int i = 0; i < values.length; i++) {
                    ret += values[i].getName() + (( i < values.length-1) ? ", " : "");
                }
                return ret;
            }

            @Override
            public boolean isValid() {
                return isMatch(targetParameter);
            }
        };
    }

    public CodeGenerator getMathodParameter()
    {
        return new CodeGenerator() {
            @Override
            public String createCode() {
                String ret = "";
                for (int i = 0; i < values.length; i++) {
                    ret += values[i].getType().getName() + " " + values[i].getName() + (( i < values.length-1) ? ", " : "");
                }
                return ret;
            }

            @Override
            public boolean isValid() {
                return true;
            }
        };
    }

    public Variabel[] getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Parameter[ " + Arrays.toString(values) + "]";
    }
}
