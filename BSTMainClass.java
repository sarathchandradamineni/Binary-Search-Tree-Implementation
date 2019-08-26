import java.util.Scanner;
class BSTMainClass
{
	Scanner sc;
	Node root;
	
	
	//Tree Creation at First
	public void treeCreation()
	{
		    //Adding the root node
			System.out.println("Enter the value of root node of the Binary Search Tree");
			int val = sc.nextInt();
			root = new Node(val);

			// Adding remaining other nodes
			int loop = 1;
			while(loop == 1)
			{
				System.out.println("Do you  want to enter more nodes then press 1 else 0");
				int ch = sc.nextInt();
				if(ch == 1)
				{
					System.out.println("Enter the value to insert in to the tree");
					int val_to_tree = sc.nextInt();

					addNode(root,val_to_tree);
				}
				else	
				{
					loop = 0;
				}
		}
		display();
	}
	
	// Function to add new node in to the Tree
	public void addNode(Node p,int val)
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
				addNode(p.lchild,val);
			}
			else if(val > p.info)
			{
				addNode(p.rchild,val);
			}
		}
			
	}
	
	// Display of the Tree
	public void display()
	{
		display(root,0);
		System.out.println("");
	}
	
	public void display(Node p,int level)
	{
		if(p == null)
			return;
		
		display(p.rchild,level+1);
		System.out.println();
		
		for(int i = 0;i < level;i++)
			System.out.print("      ");
		System.out.println(p.info);
		
		display(p.lchild,level+1);
	}
	
	
	
	public static void main(String args[])
	{
		BSTMainClass bstmc = new BSTMainClass();
		bstmc.sc = new Scanner(System.in);
		IterativeImplementation ii = new IterativeImplementation();
		RecursiveImplementation ri = new RecursiveImplementation();
		
		// Creation of the BinarySearchTree
		System.out.println("Binary Search Tree Creation");
		bstmc.treeCreation();
		
		int loop = 1;
		while(loop == 1)
		{
			System.out.println("Enter your choice");
			System.out.println("1 : Insert-Recursively\n2 : Insert Iteratively\n3 : Display");
			System.out.println("4 : Search-Iterative\n5 : Search-Recursive \n6 : Find Min value - Recursively  ");
			System.out.println("7 : Find Min value - Iteratively\n8 : Find Max value - Recursively");
			System.out.println("9 : Find Max value - Iteratively\n10 : Delete - Recursively");
			System.out.println("11 : Delete - Iteratively\n12 : Exit");
			int ch = bstmc.sc.nextInt();
			
			switch(ch)
			{
			case 1:
				System.out.println("Enter a value to insert in to the tree");
				int new_node_val = bstmc.sc.nextInt();
				ri.insertNewNode(bstmc.root, new_node_val);
				bstmc.display();
				break;
				
			case 2:
				System.out.println("Enter a value to insert in to the tree");
				int new_node_val_itr = bstmc.sc.nextInt();
				ii.insertNewNode(bstmc.root, new_node_val_itr);
				bstmc.display();
				break;
				
			case 3:
				System.out.println("Display");
				bstmc.display();
				break;
				
			case 4:
				System.out.println("Searching Iteratively.......");
				System.out.println("Enter value to search");
				int val = bstmc.sc.nextInt();
				if(ii.searchValue(bstmc.root, val))
					System.out.println("Element found in the tree");
				else
					System.out.println("Element not found in the tree");
				break;
				
			case 5:
				System.out.println("Searching Recursively");
				System.out.println("Enter value to search");
				int val_1 = bstmc.sc.nextInt();
				ri.searchValue(bstmc.root, val_1);
				break;
				
			case 6:
				ri.minNode(bstmc.root);
				break;
			
			case 7:
				int min_val_itr = ii.minNode(bstmc.root);
				System.out.println("Minimum value in the tree is "+min_val_itr);
				break;
				
			case 8:
				ri.maxNode(bstmc.root);
				break;
			
			case 9:
				int max_val_itr = ii.maxNode(bstmc.root);
				System.out.println("Maxmum value in the tree is "+max_val_itr);
				break;
				
			case 10:
				System.out.println("Enter the value to be deleted in the tree Recursively");
				
				int del_ele_rec  = bstmc.sc.nextInt();
				
				if(ii.searchValue(bstmc.root,del_ele_rec))
				{
					ii.deleteNode(bstmc.root,del_ele_rec);
				}
				else
				{
					System.out.println(del_ele_rec+" is not present in the tree");
				}
				
				bstmc.display();
				break;
			case 11:
				System.out.println("Enter the value to be deleted in the tree Iteratively");
				int del_ele_itr  = bstmc.sc.nextInt();
				
				if(ii.searchValue(bstmc.root,del_ele_itr))
				{
					ii.deleteNode(bstmc.root,del_ele_itr);
				}
				else
				{
					System.out.println(del_ele_itr+" is not present in the tree");
				}
				
				bstmc.display();
				break;
			case 12:
				System.out.println("Exit");
				loop = 0;
				break;
				
			default:
				System.out.println("You have Entered a wrong choice please try again");
				break;
			}
			
			
		}
	}
}