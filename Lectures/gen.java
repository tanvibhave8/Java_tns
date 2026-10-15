package Lectures;

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
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class gen{
    public static void main(String[] args){
        Pair<String, Integer> p = new Pair<>("Age", 25);

        String k = p.getKey();
        Integer v = p.getValue();

        System.err.println(k + ":" + v);
    }
}