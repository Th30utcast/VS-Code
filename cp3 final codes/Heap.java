
import java.util.Scanner;

public class Heap 
{
	private int [] heap;
	private int maxsize;
	private int size;
	
	public Heap(int a)
	{
		maxsize = a;
		size = 0;
		heap = new int [maxsize+1];
	}
	
	public boolean less(int i,int j)
	{
		if (heap[i]<heap[j])
		{
				return true;
		}
		else
		{
			return false;
		}
	}
	
	public void sink(int pos)
	{
		while(2*pos<=size)
		{
			int l = 2*pos;
			if((l<size) && less(l,l+1))
			{
				l++;
			}
			if (less(l,pos))
			{
				break;
			}
			swap(pos,l);
			pos = l;
		}
	}
	
	public void swim(int pos)
	{
		while (pos > 1 && less(pos/2,pos))
				{
					swap(pos/2,pos);
					pos = pos/2;
				}
	}
	
	public void insert(int element)
	{
		heap[++size] = element;
		swim(size);
	}
	

	public int extractMax()
	{
		int maxx = heap[1];
		heap[1]=heap[size--];
		heap[size+1]=maxx;
		sink(1);
		return maxx;
	}

	public void sort()
	{
		for(int i=1;i<heap.length;i++)
		{
			extractMax();
		}
		for(int i=1;i<heap.length;i++)
		{
			System.out.print(heap[i]+" ");
		}
	}
	
	private void swap(int a, int b)
	{
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Heap h = new Heap(n);
		for(int i=1;i<h.heap.length;i++)
		{
			h.insert(sc.nextInt());
		}
		for(int i=1;i<h.heap.length;i++)
		{
			System.out.print(h.heap[i]+" ");
		}
		System.out.println();
		h.sort();
		sc.close();
	}
}