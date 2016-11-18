import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		
		String stmt="A quick brown fox jumps over the lazy dog owl";
		// TODO Auto-generated method stub
				MapTest m=new MapTest();
		     m.arrange(stmt);
	}

	private void arrange(String stmt) {
		// TODO Auto-generated method stub
		String temp[]=stmt.split(" ");
		int i=temp.length-1;
		Map<String,String> mp=new TreeMap<String,String>();
		while(i>=0){
			
			char c=temp[i].charAt(0);
			String key=String.valueOf(c);
		//	System.out.println("key "+key);
			mp.put(key,temp[i]);
		i--;
		
		}
		for(Map.Entry<String, String> m:mp.entrySet()){
			System.out.println("key "+m.getKey()+" Value "+m.getValue());
		}
		//System.out.println("length "+temp.length);
	}

}
