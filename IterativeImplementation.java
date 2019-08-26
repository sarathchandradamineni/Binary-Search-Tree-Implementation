import java.util.Scanner;
class IterativeImplementation
{
	Node del_parent;
	Scanner  sc = new Scanner(System.in);
	
	//Searching for the value in the tree Iteratively
	public boolean searchValue(Node p,int val)
	{
		while(p != null)
		{
			if(p.info == val)
				return true;
			else if(val < p.info)
				p = p.lchild;
			else if(val > p.info)
				p = p.rchild;
		}
		return false;
	}
	
	// Finding the minimum value in the tree Iteratively
	public int minNode(Node p)
	{
		while(p != null)
		{
		if(p.lchild == null)
			return p.info;
		
		p = p.lchild;
		}
		return 0;
	}
	
	// Finding the maximum value in the tree Iteratively
	public int maxNode(Node p)
	{
		while(p != null)
		{
			if(p.rchild == null)
				return p.info;
			
			p = p.rchild;
		}
		return 0;
	}
	
	// Inserting a new node in to the tree Iteratively
	public void insertNewNode(Node p,int new_node_val)
	{
		while(p != null)
		{
			if(new_node_val == p.info)
			{
				System.out.println(new_node_val+" is aldready present in the tree");
				break;
			}
			else if(new_node_val < p.info && p.lchild == null)
			{
				Node  new_node = new Node(new_node_val);
				p.lchild = new_node;
				break;
			}
			else if(new_node_val > p.info && p.rchild == null)
			{
				Node new_node = new Node(new_node_val);
				p.rchild = new_node;
				break;
			}
			else if(new_node_val < p.info)
			{
				p = p.lchild;
			}
			else if(new_node_val > p.info)
			{
				p = p.rchild;
			}
		}
	}
	
	//Deletion of the node 
	public void deleteNode(Node root,int val_del)
	{
		Node par = null,p = root;
		
		//Refers to the node to be deleted and its parents
		while(p != null)
		{
			if(p.info == val_del)
				break;
			par = p;
			if(val_del  < p.info)
				p = p.lchild;
			else if(val_del > p.info)
				p = p.rchild;				
		}
		
		// If node has 2 children
		Node ps,s;
		if(p.lchild != null && p.rchild != null)
		{	
			s = p.rchild;
			ps = p;
			
			while(s.lchild != null)
			{
				ps = s;
				s = s.lchild;
			}
			
			p.info = s.info;
			p = s;
			par = ps;
		}
		
		//If the node has 1 child or no children
		Node ch = null;
		if(p.lchild != null)
			ch = p.lchild;
		else
			ch = p.rchild;
		
		if(par == null)
			root = ch;
		else if(p == par.lchild) //if the node to be deleted is left child of the parent node
			par.lchild = ch;
		else if(p == par.rchild) //if the node to be deleted is right vhild of the parent node
			par.rchild = ch;
	
	}
}