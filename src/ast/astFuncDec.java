package ast;
import java.util.List;

public class astFuncDec extends AstDec{
    public String type;
    public String id;
    public List<AstParam> params;
    public AstStmtList stmt;

    public astFuncDec|(String type, string id, List<AstParam> params, AstStmtList stmt)
    {
        this.serialNumber = AstNodeSerialNumber.getFresh();
        this.type = type;
        this.id = id;
        this.params = params;
        this.stmt = stmt;
    }
    public void printMe()
    {
        System.out.print("AST NODE FUNC DEC ( " + type + " " + id + " )\n"); /* AST NODE FUNC void foo */
        AstGraphviz.getInstance().logNode(serialNumber, "FUNC\\n(" + id + ")");
        if (params != null) {
            for (AstParam p : params) {
                p.printMe();
                AstGraphviz.getInstance().logEdge(serialNumber, p.serialNumber);
            }
        }
        if (body != null) {
            body.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, body.serialNumber);
        }
    }
}
