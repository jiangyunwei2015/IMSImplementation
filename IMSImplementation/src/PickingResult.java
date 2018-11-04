/**
 * Description: PickingResult for IMS pickProduct method
 * Extends OperationResult
 * @author Yunwei Jiang
 * */
public class PickingResult extends OperationResult{
	
	public PickingResult(boolean result, String productId, int stockLevel, int requiredQuantity, String location)
	{
		this.productId = productId;
		this.currentLevel = stockLevel;
		this.operationResult = result;
		this.location = location;
		this.requiredQuantity = requiredQuantity;
	}
	//When picking operation fails because the product doesn't exist,use this constructor
	public PickingResult()
	{
		this.productName = null;
		this.currentLevel = null;
		this.operationResult = false;
		this.location = null;
		this.requiredQuantity = null;
	}
		
	@Override
	public String toString()
	{
		String output = null;
		if(this.operationResult == true)
		{
			output = ("After Picking of "+userId+":  "+productName+" in "+location+" has stocklevel of "+currentLevel);
		}
		else
		{
			//If the product name is null, means the product is not in the productName map
			if(productName == null)
			{
				output =  ("This product doesn't exist!");
			}
			//This means that the picking operation need more quantity of product in stock
			else
			{
				output =  ("The Picking opeartion failed! The required quantity "+requiredQuantity+
						" is more than current stocklevel: "+currentLevel);
			}
		}
		return output;
	}
}
