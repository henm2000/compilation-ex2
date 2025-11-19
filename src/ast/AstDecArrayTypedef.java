package ast;

public class AstDecArrayTypedef extends AstDec
{
    public String id;
    public String baseType;

    public AstDecArrayTypedef(String id, String baseType)
    {
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== dec -> arrayTypedef\n");
        this.id = id;
        this.baseType = baseType;
    }

    public void printMe()
    {
        System.out.print("AST NODE ARRAY TYPEDEF ( " + id + " : " + baseType + " )\n");
        AstGraphviz.getInstance().logNode(serialNumber, "ARRAYTYPE\\n(" + id + ")");
    }
}