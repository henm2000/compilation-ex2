package ast;

public class AstStmtReturn extends AstStmt
{
    public AstExp retExp; // may be null

    public AstStmtReturn(AstExp retExp)
    {
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== stmt -> RETURN\n");
        this.retExp = retExp;
    }

    public void printMe()
    {
        System.out.print("AST NODE RETURN\n");
        AstGraphviz.getInstance().logNode(serialNumber, "RETURN");
        if (retExp != null) {
            retExp.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, retExp.serialNumber);
        }
    }
}