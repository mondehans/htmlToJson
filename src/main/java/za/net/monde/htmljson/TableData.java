package za.net.monde.htmljson;

public class TableData extends TableDataBase{

	private final String tech;
	private final String reason;
	private String lifeCycle;

	private TableData(final String tech, final String use, final String reason, final String lifeCycle) {
		super(use);
		this.tech = tech;
		this.reason = reason;
		this.lifeCycle = lifeCycle;
	}

	public String getTech() {
		return tech;
	}

	public String getReason() {
		return reason;
	}

	public String getLifeCycle() {
		return lifeCycle;
	}

	public static class TableDataBuilder {

		private String tech;
		private String use;
		private String reason;
		private String lifeCycle;

		public TableDataBuilder(final String tech, final String use, final String reason, final String lifeCycle) {
			this.tech = tech;
			this.use = use;
			this.reason = reason;
			this.lifeCycle = lifeCycle;

		}

		public TableDataBuilder withTech(String tech) {
			this.tech = tech;
			return this;
		}

		public TableDataBuilder() {

		}

		public TableDataBuilder withUse(String use) {
			this.use = use;
			return this;
		}

		public TableDataBuilder withReason(String reason) {
			this.reason = reason;
			return this;
		}

		public TableDataBuilder withLifeCycle(String lifeCycle) {
			this.lifeCycle = lifeCycle;
			return this;
		}
		
		public TableData build(){
			return new TableData(tech, use, reason, lifeCycle);
		}
	}

}
