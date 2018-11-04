import java.util.HashMap;


/**
 * Class: User implements Runnable
 * User will do the picking and restocking operations in IMS system
 * @author Yunwei Jiang
 * 
 * */

/*
 * Description: Operation class
 * Define the operation for each user thread, encapsulate all parameters for users.
 * */
class Operation {
	String productId;
	Integer requiredQuantity;
	String operation;//To classify which operations(pick or restock)
	//For picking and restocking operation
	public Operation(String productId,Integer requiredQuantity, String operation)
	{
		this.productId = productId;
		this.requiredQuantity = requiredQuantity;
		this.operation = operation;
	}
}

public class User implements  Runnable{
	
	//Current IMS instance to provide common data
	private IMSImplementation IMS;
	private String userId;//id for each user thread
	private Operation userOperation;
	public User(IMSImplementation IMS,String userId)
	{
		this.IMS = IMS;
		this.userId = userId;
	}
	public void setOperation(Operation operation)
	{
		this.userOperation = operation;
	}
	
	@Override
	public void run() {
		try 
		{
			//check which operation to run
			if(userOperation != null)
			{
				switch (userOperation.operation) 
				{
					case "picks":
						PickingResult pickingResult = IMS.pickProduct(userOperation.productId,userOperation.requiredQuantity);
						//Print out picking operation result
						System.out.println("User "+userId+": "+pickingResult.toString());
						break;
					case "restocks":
						RestockingResult restockingResult = IMS.restockProduct(userOperation.productId,userOperation.requiredQuantity);
						//Print out picking operation result
						System.out.println("User "+userId+": "+restockingResult.toString());
						break;
					default:
						System.out.println("User "+userId+": Invalid Operation.");
						break;
				}
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
