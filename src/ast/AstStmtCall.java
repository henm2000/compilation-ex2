package ast;

public class AstStmtCall extends AstStmt {
    public AstExp call;

    public AstStmtCall(AstExp call) {
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== stmt -> callExp SEMICOLON\n");
        this.call = call;
    }

    public void printMe() {
        System.out.print("AST NODE STMT CALL\n");
        AstGraphviz.getInstance().logNode(serialNumber, "CALL_STMT");

        if (call != null) {
            call.printMe();
            AstGraphviz.getInstance().logEdge(serialNumber, call.serialNumber);
        }
    }
}