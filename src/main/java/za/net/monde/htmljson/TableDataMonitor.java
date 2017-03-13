package za.net.monde.htmljson;

public class TableDataMonitor extends TableDataBase {
	private final String tech;
	private final String reason;

	
	protected TableDataMonitor(final String tech, final String use, final String reason) {
		super(use);
		this.tech=tech;
		this.reason=reason;
	}

	
	public String getTech() {
		return tech;
	}


	public String getReason() {
		return reason;
	}


	public static class TableDataMonitorBuilder {

		private  String tech;
		private  String use;
		private  String reason;

		public TableDataMonitorBuilder(final String tech, final String use, final String reason) {
			this.tech = tech;
			this.use = use;
			this.reason = reason;

		}

		public TableDataMonitorBuilder withTech(String tech) {
			this.tech = tech;
			return this;
		}

		public TableDataMonitorBuilder withUse(String use) {
			this.use = use;
			return this;
		}
		public TableDataMonitorBuilder() {

		}

		public TableDataMonitorBuilder withReason(String reason) {
			this.reason = reason;
			return this;
		}

		
		public TableDataMonitor build(){
			return new TableDataMonitor(tech, use, reason);
		}
	}

}
