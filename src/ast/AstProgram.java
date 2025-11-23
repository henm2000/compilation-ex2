package ast;
import java.util.List;

public class AstProgram extends AstNode
{
	public List<AstDec> decList;

	/*******************/
	/*  CONSTRUCTOR(S) */
	/*******************/
	public AstProgram( List<AstDec> declst)
	{
		SerialNumber = AstNodeSerialNumber.getFresh();
        this.decList = declst;
	}
    public printMe()
    {
        System.out.println("AST NODE PROG\n");
        AstGraphviz.getInstance().logNode()
        if (decList != Null){
            for (AstDec d : decList){
                if (d != Null){
                    d.printMe();
                    AstGraphviz.getInstance.logEdge(this.serialNumber,d.serialNumber);
                }
            }
        }
    }
}