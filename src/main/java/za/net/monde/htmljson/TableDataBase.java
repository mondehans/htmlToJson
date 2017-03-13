package za.net.monde.htmljson;


public class TableDataBase {

	private String use;

	
	public String getUse() {
		return use;
	}

	protected TableDataBase(final String use) {
		this.use=use;
	}

	public static class TableDataBuilder {

		private String use;

		public TableDataBuilder(final String use) {

			this.use = use;

		}

		public TableDataBuilder() {

		}

		public TableDataBuilder withUse(String use) {
			this.use = use;
			return this;
		}

		public TableDataBase build() {
			return new TableDataBase(use);
		}
	}
}
