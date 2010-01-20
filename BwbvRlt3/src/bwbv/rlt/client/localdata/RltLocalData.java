package bwbv.rlt.client.localdata;

import java.util.ArrayList;

import bwbv.rlt.client.domain.Rlt;
import bwbv.rlt.client.domain.Spieler;
import bwbv.rlt.client.domain.Verein;

public class RltLocalData {

	private final static Verein[] _vereine = {
			new Verein(1, 9, "SV", "Fellbach", "NW", null, null, new Spieler[] {
					new Spieler(1, "V-1234", "NW", 9, "Hess", "Andreas", null, null, "m"),
					new Spieler(2, "V-1235", "NW", 9, "Ballhause", "Uli", null, null, "m") }),
			new Verein(2, 161, "TV", "Echterdingen", "NW", null, null, new Spieler[] {
					new Spieler(4, "V-24096", "NW", 161, "Ott", "Susanne", null, null, "w"),
					new Spieler(5, "V-19889", "NW", 161, "Heinzmann", "Christina", null, null, "w"),
					new Spieler(6, "V-17963", "NW", 161, "Kreuzburg", "Heide", null, null, "w") }),
			new Verein(3, 329, "MTV", "Aalen", "NW", null, null, new Spieler[] { new Spieler(3, "V-10826", "NW", 329,
					"Kiwus", "Thomas", null, null, "m") }) };

	private final static Rlt[] _rlts = {
			new Rlt(1, Rlt.Kat.Senioren, Rlt.Status.geplant, null, "1. BezRlt NW", "Feuerbach", null, null, "21./22.11.2009",
					null, null, null, new String[] { "HE", "DE", "MX" }, null),
			new Rlt(2, Rlt.Kat.Senioren, Rlt.Status.geplant, null, "2. BezRlt NW", "Kirchheim", null, null, "01./02.12.2009",
					null, null, null, new String[] { "HD", "DD", "MX" }, null),
			new Rlt(3, Rlt.Kat.Senioren, Rlt.Status.geplant, null, "3. BezRlt NW", "Kirchheim", null, null, "01./02.12.2009",
							null, null, null, new String[] {"HE", "DE", "HD", "DD"}, null),
			new Rlt(4, Rlt.Kat.Jugend, Rlt.Status.geplant, null, "1. JBezRlt NW", "Gerlingen", null, null, "13./14.01.2010",
					null, null, null, new String[] { "U13JE", "U13ME" }, null) };

	public static Verein[] getVereine() {
		return _vereine;
	}

	public static Rlt[] getRlts() {
		return _rlts;
	}
	
	public static Rlt[] getRltsByKat(Rlt.Kat kat) {
		ArrayList<Rlt> l = new ArrayList<Rlt>();
		for (Rlt rlt : _rlts) {
			if(rlt.getRltkat() != null && rlt.getRltkat().equals(kat))
				l.add(rlt);
		}
		return (Rlt[]) l.toArray(new Rlt[l.size()]);
	}

}
