package Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class Tries {

	private class Node
	{
		char data;
		boolean isTerminal;
		HashMap<Character,Node>children;
		Node(char data,boolean isTerminal)
		{
			this.data=data;
			children=new HashMap<>();
			this.isTerminal=isTerminal;
		}
	}
	
	private int numOfWords;
	private Node root;
	
	Tries()
	{
		this.numOfWords=0;
		root=new Node('\0',false);
	}
	
	public void addWord(String word)
	{
		addWord(this.root,word);
	}
	
	private void addWord(Node parent, String word)
	{
		if(word.length()==0)
		{
			if(parent.isTerminal)
			{
				// Word Already Exists
			}
			else
			{
				this.numOfWords++;
				parent.isTerminal=true;
			}
			return ;
		}
		char cc=word.charAt(0);
		String ros=word.substring(1);
		Node child=parent.children.get(cc);
		if(child==null)
		{
			 child=new Node(cc,false);
			 parent.children.put(cc,child);
		}
	    addWord(child,ros);
	}
	
	public void display()
	{
		 display(this.root, " ");	
	}
	
	private void display(Node node, String osf)
	{
		if(node.isTerminal)
		{
			String toDisplay=osf.substring(1);
			System.out.println(toDisplay);
		}
		ArrayList<Character>keys=new ArrayList<>(node.children.keySet());
		for(Character key:keys)
		{
		   display(node.children.get(key),osf+key);	
		}
	}
	
	public boolean search(String word)
	{
		return search(this.root,word);	
	}
	
	private boolean search(Node parent, String word)
	{
		if(word.length()==0)
		{
		if(parent.isTerminal)
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		char cc=word.charAt(0);
		String ros=word.substring(1);
		Node child=parent.children.get(cc);
		if(child==null)
		{
			return false;
		}
		return search(child,ros);
	}
	
	public void remove(String word)
    {
    	remove(this.root,word);
    }
    
    private void remove(Node parent, String word)
    {
    	if(word.length()==0)
    	{
    		if(parent.isTerminal)
    		{
    			parent.isTerminal=false;
    			numOfWords--;
    		}
    		else
    		{
    			// word is a part of some other word
    		}
    		return;
    	}
    	char cc=word.charAt(0);
    	String ros=word.substring(1);
    	Node child=parent.children.get(cc);
    	if(child==null)
    	{
    		return ;
    	}
    	remove(child,ros);
    	
    	if(!child.isTerminal && child.children.size()==0)
    	{
    		parent.children.remove(cc);
    	}
    }
}
