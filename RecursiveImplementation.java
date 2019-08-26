import java.util.Scanner;
class RecursiveImplementation
{
	Scanner sc = new Scanner(System.in);
	
	//Searching for the value in the tree Recursively
	public void searchValue(Node p,int val)
	{
		if(p == null)
			System.out.println("Element not found in the tree");
		else if(p.info == val)
			System.out.println("Element is present in the tree");
		else if(val < p.info)
			searchValue(p.lchild,val);
		else if(val > p.info)
			searchValue(p.rchild,val);
	}
	
	// Finding the minimum value in the tree Recursively
	public void minNode(Node p)
	{
		if(p.lchild == null)
			System.out.println("Minimum value in the tree is "+p.info);
		else
			minNode(p.lchild);
	}
	
	// Finding the maximum value in the tree Recursively
	public void maxNode(Node p)
	{
		if(p.rchild == null)
			System.out.println("Maximum value in the tree is "+p.info);
		else
			maxNode(p.rchild);
	}
	
	// Inserting a new node in to the tree Recursively
	public void insertNewNode(Node p,int val)
	{
		if(p.info == val)
		{
			System.out.println("Element is aldready present in the tree");
		}
	    else if(p.lchild == null && val < p.info)
		{
			Node new_node = new Node(val);
			p.lchild = new_node;
		}
		else if(p.rchild == null && val > p.info)
		{
			Node new_node = new Node(val);
			p.rchild = new_node;
		}
		else
		{
			if(val < p.info)
			{
				insertNewNode(p.lchild,val);
			}
			else if(val > p.info)
			{
				insertNewNode(p.rchild,val);
			}
		}
	}
	
}