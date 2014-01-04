package server_battle;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class Commands{
	@Parameters(commandDescription = "Add unit to the map")
	public static class createUnit{
		@Parameter
		public String[] unitType = null;
		
		@Parameter(names = {"-H", "-h", "-Health", "-health"}, description = "Absolute health of unit")
		public Integer health = -1;
	}
}
