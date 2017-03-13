package za.net.monde.htmljson;

import java.util.Map;

public class DataLineUtils {

	public TableDataBase createProgLine(String cat, Map<String, String> data) {

		final String tech = data.get("Tech");
		final String reason = data.get("Reason");
		final String lifeCycle = data.get("Lifecycle");
		final String use = data.get("Use");
		final String infrastructure = data.get("Infrastructure");

		if ("Programming Stack".equals(cat) || "Build Stack".equals(cat)) {
			return new TableData.TableDataBuilder(tech, use, reason, lifeCycle).build();
		} else {
			if ("Monitoring".equals(cat)) {
				return new TableDataMonitor.TableDataMonitorBuilder().withTech(tech).withReason(reason).withUse(use)
						.build();
			} else {
				if ("Infrastructure".equals(cat)) {
					return new TableDataInfrastructure.TableDataInfrastructureBuilder()
							.withInfrastructure(infrastructure).withUse(use).build();
				} else {
					return new TableDataBase.TableDataBuilder().withUse(use).build();
				}
			}

		}

	}

}
