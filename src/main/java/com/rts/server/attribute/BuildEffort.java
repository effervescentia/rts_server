package com.rts.server.attribute;

public class BuildEffort extends Attribute {

	private long buildEffort;

	public BuildEffort(long pBuildEffort) {
		type = AttributeType.BuildEffort;
		buildEffort = pBuildEffort;
	}

	public void setBuildEffort(long pBuildEffort) {
		buildEffort = pBuildEffort;
	}

	public long getBuildEffort() {
		return buildEffort;
	}

}
