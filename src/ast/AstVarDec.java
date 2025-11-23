package ast;
public class AstVarDec extends AstDec{

    public String type;
    public String id;
    public AstExp expression;    
    public int serialNumber;

    public AstVarDec(String type, String id, AstExp expression){

        this.serialNumber = AstNodeSerialNumber.getFresh();
        this.type = type;
        this.id = id;
        this.expression = expression;

    }

    public void printMe(){
        
        System.out.println("Ast Node Dec ("+ type +" " + id + "\n");
        AstGraphviz.getInstance().logNode(serialNumber, "DEC_VAR\\n(" + type + " " + id + ")");
        if (expression != null){
            expression.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, expression.serialNumber);
        }

    }
}
