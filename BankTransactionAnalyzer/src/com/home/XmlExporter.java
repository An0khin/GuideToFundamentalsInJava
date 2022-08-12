package com.home;

public class XmlExporter implements Exporter {

	@Override
	public String export(SummaryStatistics summaryStatistics) {
		String result = "<XmlError>";
		
		result += "<sum>" + summaryStatistics.getSum() + "</sum>";
		result += "<average>" + summaryStatistics.getAverage() + "</average>";
		result += "<max>" + summaryStatistics.getMax() + "</max>";
		result += "<min>" + summaryStatistics.getMin() + "</min>";
		
		result += "</XmlError>";
		
		return result;
	}

}
