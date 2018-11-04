/**
 * Description: RestockingResult for IMS restockProduct method
 * 
 * 
 * */
public class RestockingResult extends OperationResult {

	public RestockingResult(boolean result, String productId, int stockLevel,int requiredQuantity, String location)
	{
		this.productId = productId;
		this.currentLevel = stockLevel;
		this.operationResult = result;
		this.location = location;
		this.requiredQuantity = requiredQuantity;
	}
	//When restocking operation fails because the product doesn't exist,use this constructor
	public RestockingResult()
	{
		this.productId = null;
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
			output = (userId + ": After Restocking of "+requiredQuantity+":  "+productName+" in "+location+" has stocklevel of "+currentLevel);
		}
		else
		{
			//If the product name is null, means the product is not in the productName map
			if(productName == null)
			{
				output =  ("This product doesn't exist!");
			}
		}
		return output;
	}
}
