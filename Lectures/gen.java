package Lectures;

class Box<T> {
	private T item;
	void set(T item)
	{
		this.item=item;
	}
	T get()
	{
		return item;
	}
     
}

class gen
{
	public static void main(String[] args)
	{
		Box<String> box = new Box<>();
		box.set("hello");
		String s = box.get();
		System.out.println(s);
	}
}



/*
 1. compile time errors detected. Without generics we cant detect
    compile time errors, the code will break while executing(run time)

 2. No manual casting

 3. resuable code. (One box class works for any type).

 Rules:
 1. Mention the wrapper class.
 2. Java automatically performs autoboxing and unboxing.
*/