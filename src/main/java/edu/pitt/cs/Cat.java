package edu.pitt.cs;

import org.mockito.*;

public interface Cat {
	public static Cat createInstance(InstanceType type, int id, String name) {
		switch (type) {
			case IMPL:
				return new CatImpl(id, name);
			case BUGGY:
				return new CatBuggy(id, name);
			case SOLUTION:
				return new CatSolution(id, name);
			case MOCK:
			    // TODO: Return a mock object that emulates the behavior of a real object.
				Cat fakecat = Mockito.mock(Cat.class);
				Mockito.when(fakecat.getId()).thenReturn(id);
				Mockito.when(fakecat.getName()).thenReturn(name);
				Mockito.when(fakecat.toString()).thenReturn("ID " + id + ". " + name);
				Mockito.when(fakecat.getRented()).thenReturn(false);
				return fakecat;
			default:
				assert(false);
				return null;
		}
	}

	// WARNING: You are not allowed to change any part of the interface.
	// That means you cannot add any method nor modify any of these methods.
	
	public void rentCat();

	public void returnCat();

	public void renameCat(String name);

	public String getName();

	public int getId();

	public boolean getRented();

	public String toString();
}
