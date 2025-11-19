package ast;

public class AstExpNew extends AstExp
{
    public String typeName;
    public AstExp sizeExpr; // for array creation; null if simple new

    public AstExpNew(String typeName)
    {
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== exp -> NEW type\n");
        this.typeName = typeName;
    }

    public AstExpNew(String typeName, AstExp sizeExpr)
    {
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== exp -> NEW type [ exp ]\n");
        this.typeName = typeName;
        this.sizeExpr = sizeExpr;
    }

    public void printMe()
    {
        System.out.print("AST NODE NEW EXP ( " + typeName + " )\n");
        AstGraphviz.getInstance().logNode(serialNumber, "NEW\\n(" + typeName + ")");
        if (sizeExpr != null) {
            sizeExpr.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, sizeExpr.serialNumber);
        }
    }
}