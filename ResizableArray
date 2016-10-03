
public class ResizableArray {
	
	private int items[]=new int[8];
	private int size=0;
	
	public int size(){
		return size;
	}
	public void set(int index, int item){
		if (index<0 ||index>size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		items[index]=item;
	}
	
	public int get(int index){
		if (index<0 ||index>size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
		
	   return items[index];	
	}
	public void append(int item){
		ensureExtraCapacity();
		items[size]=item;
		size++;
		
	}
	private void  ensureExtraCapacity(){
		if(size==items.length){
			int[] copy=new int[size*2];
			System.arraycopy(items, 0, copy, 0, size);
			System.out.println("Capacity Increased");
			items=copy;
		}
	}
	


	public void showItems() {
		// TODO Auto-generated method stub
		System.out.println("Resizable Array elements are as follows");
		for(int i=0;i<size;i++){
			System.out.println(items[i]);
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizableArray rArray=new ResizableArray();
		rArray.append(1);
		rArray.append(2);
		rArray.append(3);
		rArray.append(4);
		rArray.append(5);
		rArray.append(6);
		rArray.append(7);
		rArray.append(8);
		
		rArray.append(45);
		
		rArray.set(0, 8);
		
		rArray.showItems();
		
	}

}
