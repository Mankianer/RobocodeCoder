package de.mankianer.robocodecoder.logic.klassen;

public abstract class Aktion<T extends Variabel>{

    private Parameter parameter;
    private String name;

    public Aktion(String name, Parameter parameter) {
        this.name = name;
        this.parameter = parameter;
    }

//    public T getReturn();
//
//    public void setReturn(T ret);
//
//    public String getName();
//
//    public boolean addAktion(Aktion aktion);
//
//    public boolean removeAktion(Aktion aktion);
//
//    public CodeGenerator getAufruf(Parameter sourceParameter){
//        CodeGenerator parameterCode = sourceParameter.getCallParameter(parameter);
//        return new CodeGenerator() {
//            @Override
//            public String createCode() {
//                return name + "(" + parameterCode.createCode() + ")";
//            }
//
//            @Override
//            public boolean isValid() {
//                return name != null && !name.isEmpty() && parameterCode.isValid();
//            }
//        };
//
//    }
//
//    public CodeGenerator getBody();
}
