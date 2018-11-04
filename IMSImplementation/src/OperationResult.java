/**
 * Abstract class: OperationResult
 * Parent class for PickingResult and RestockingResult
 * @author Yunwei Jiang
 * 
 * */
public class OperationResult {
	protected String productId;
	protected String productName;
	protected Integer currentLevel;
	protected String location;
	protected boolean operationResult; 
	protected String userId;
	protected Integer requiredQuantity;
	
	protected void setOperationRsult(boolean result)
	{
		operationResult = result;
	}
	
	protected boolean getOperationRsult()
	{
		return operationResult;
	}
	@Override
	public String toString()
	{
		//System.out.println("After this Operation of "+userId+":  "+productName+" in "+location+
		//		" has stocklevel of "+currentLevel);
		return ("After this Operation of "+userId+":  "+productName+" in "+location+" has stocklevel of "+currentLevel);
	}
	
}
