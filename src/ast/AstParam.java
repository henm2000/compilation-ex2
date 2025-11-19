package ast;

public class AstParam extends AstNode
{
    public String typeName;
    public String id;

    public AstParam(String typeName, String id)
    {
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== param -> type ID\n");
        this.typeName = typeName;
        this.id = id;
    }

    public void printMe()
    {
        System.out.print("AST NODE PARAM ( " + typeName + " " + id + " )\n");
        AstGraphviz.getInstance().logNode(serialNumber, "PARAM\\n(" + typeName + " " + id + ")");
    }
}