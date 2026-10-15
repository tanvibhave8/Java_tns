package Lectures;

import java.util.Arrays;
import java.util.List;

// class Box<T> {
// 	private T item;
// 	void set(T item)
// 	{
// 		this.item=item;
// 	}
// 	T get()
// 	{
// 		return item;
// 	}
     
// }

// class gen
// {
// 	public static void main(String[] args)
// 	{
// 		Box<String> box = new Box<>();
// 		box.set("hello");
// 		String s = box.get();
// 		System.out.println(s);
// 	}
// }



/*
 1. compile time errors detected. Without generics we cant detect
    compile time errors, the code will break while executing(run time)

 2. No manual casting

 3. resuable code. (One box class works for any type).

 Rules:
 1. Mention the wrapper class.
 2. Java automatically performs autoboxing and unboxing.
*/

// Multi type parameters

// class Pair<K, V> {
//     private K key;
//     private V value;

//     public Pair(K key, V value) {
//         this.key = key;
//         this.value = value;
//     }

//     public K getKey() {
//         return key;
//     }

//     public V getValue() {
//         return value;
//     }
// }

// class gen{
//     public static void main(String[] args){
//         Pair<String, Integer> p = new Pair<>("Age", 25);

//         String k = p.getKey();
//         Integer v = p.getValue();

//         System.err.println(k + ":" + v);
//     }
// }

// Generic method
// class Util{
//     static <T> void printTwice(T value){
//         System.out.println(value);
//         System.out.println(value);
//     }

//     static <T> T firstOf(T a, T b){
//         return b;
//     }
// }

// class gen{
//     public static void main(String[] args){
//         Util.printTwice(100);
//         System.out.println(Util.firstOf("Hi", "Hello"));
//     }
// }

// class gen{
//     public static void printList(List<?> list){
//        for(Object o : list){
//         System.out.println(o);
//        }
//     }
// public static void main(String[] args) {
//     List<String> names= Arrays.asList("Anish", "Varun","Bhumi");
//     List<Integer> nums =Arrays.asList(100,99,98);
//     List<Double>prices=Arrays.asList(99.6,99.5,90.7);

//     System.out.println("Name : ");
//     printList(names);

//     System.out.println("\nNumbers :");
//     printList(nums);

//     System.out.println("\nPrices :");
//     printList(prices);
// }    
// }


public class gen{

	static double sum(List<? extends Number>list)
	{
		double total = 0;
		for(Number n : list)
		{
			total += n.doubleValue();
		}
		return total;
	}
	public static void main(String[] args) {
		List<Integer> integers= List.of(1,2,3);
		List<Float> floats= List.of(1.6f, 2.5f, 3.7f);
		List<Double> decimals= List.of(1.5,2.8,3.9);
		
		System.out.println(integers);
		System.out.println(floats);
		System.out.println(decimals);
	}

}