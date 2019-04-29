package useless_junk;

public class MyObjectWithIdEquals {

	private Integer id;

	public MyObjectWithIdEquals(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return id.equals(((MyObjectWithIdEquals) obj).id);
	}

}
