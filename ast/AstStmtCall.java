package ast;

public class AstStmtCall extends AstStmt {
    public final AstExp call;

    public AstStmtCall(AstExp call) {
        this.call = call;
    }

    @Override
    public String toString() {
        return "AstStmtCall(" + call + ")";
    }
}