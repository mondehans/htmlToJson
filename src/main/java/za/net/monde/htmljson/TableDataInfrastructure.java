package za.net.monde.htmljson;

public class TableDataInfrastructure extends TableDataBase {

	private final String infrastructure;
	
	protected TableDataInfrastructure(String use, String infrastructure) {
		super(use);
		this.infrastructure=infrastructure;
	}

	

	public String getInfrastructure() {
		return infrastructure;
	}

	public static class TableDataInfrastructureBuilder {
       
		private String infrastructure;
		private String use;

		public TableDataInfrastructureBuilder(final String use, final String infrastructure) {
			this.infrastructure = infrastructure;
			this.use=use;
		}

		public TableDataInfrastructureBuilder withUse(String use) {
			this.use =use;
			return this;
		}

		public TableDataInfrastructureBuilder withInfrastructure(String infrastructure) {
			this.infrastructure =infrastructure;
			return this;
		}
		public TableDataInfrastructureBuilder() {

		}
		
		public TableDataInfrastructure build(){
			return new TableDataInfrastructure(use,infrastructure);
		}
	}
}
