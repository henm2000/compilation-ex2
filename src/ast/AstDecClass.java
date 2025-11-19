package ast;

import java.util.List;

public class AstDecClass extends AstDec
{
    public String name;
    public String extendsName; // may be null
    public List<AstDec> fields;

    public AstDecClass(String name, String extendsName, List<AstDec> fields)
    {
        serialNumber = AstNodeSerialNumber.getFresh();
        System.out.print("====================== dec -> classDec\n");
        this.name = name;
        this.extendsName = extendsName;
        this.fields = fields;
    }

    public void printMe()
    {
        System.out.print("AST NODE CLASS DEC ( " + name + " )\n");
        AstGraphviz.getInstance().logNode(serialNumber, "CLASS\\n(" + name + ")");
        if (fields != null) {
            for (AstDec f : fields) {
                f.printMe();
                AstGraphviz.getInstance().logEdge(serialNumber, f.serialNumber);
            }
        }
    }
}