package ast;
import java.util.List;
public class AstClassDec extends AstDec {
    public  String id;
    public String extend;
    public List<AstDec> fields;

    public AstClassDec(String id, String extend, List<AstDec> fields)
    {
        this.serialNumber = AstNodeSerialNumber.getFresh();
        this.id = id;
        this.extend = extend;
        this.fields = fields;
    }
    public void printMe()
    {
        System.out.print("AST NODE CLASS DEC ( " + id + " )\n");
        AstGraphviz.getInstance().logNode(serialNumber, "CLASS\\n(" + id + ")");
        if (fields != null) {
            for (AstDec f : fields) {
                f.printMe();
                AstGraphviz.getInstance().logEdge(serialNumber, f.serialNumber);
            }
    
    }

}
