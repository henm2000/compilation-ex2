package ast;

public class AstStmtVarDec extends AstStmt
{
    public AstDec dec;

    public AstStmtVarDec(AstDec dec) 
    {
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== stmt -> varDec\n");
        this.dec = dec;
    }

    public void printMe() {
        System.out.print("AST NODE STMT VAR DEC\n");
        AstGraphviz.getInstance().logNode(serialNumber, "VARDECL STMT");
        if (dec != null) {
            dec.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, dec.serialNumber);
        }
    }
}