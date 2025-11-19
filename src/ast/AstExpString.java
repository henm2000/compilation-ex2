package ast;

public class AstExpString extends AstExp
{
    public String value;

    public AstExpString(String value)
    {
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== exp -> STRING\n");
        this.value = value;
    }

    public void printMe()
    {
        System.out.print("AST NODE STRING EXP ( " + value + " )\n");
        AstGraphviz.getInstance().logNode(serialNumber, "STRING\\n(" + value + ")");
    }
}