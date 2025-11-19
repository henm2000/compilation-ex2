package ast;

import java.util.List;

public class AstProgram extends AstNode
{
    public List<AstDec> decls;

    public AstProgram(List<AstDec> decls)
    {
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== program -> dec {dec}\n");
        this.decls = decls;
    }

    public void printMe()
    {
        System.out.print("AST NODE PROGRAM\n");
        AstGraphviz.getInstance().logNode(serialNumber, "PROGRAM");
        if (decls != null) {
            for (AstDec d : decls) {
                if (d != null) {
                    d.printMe();
                    AstGraphviz.getInstance().logEdge(serialNumber, d.serialNumber);
                }
            }
        }
    }
}