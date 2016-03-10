package api;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Trip {
	private String start;
	private int startWoeid;
	private String dest;
	private int destWoeid;
	private Calendar arrivetime; // We are using calendar for ease of storing time
	private Calendar commutetime; // but we will only be using the time fields
	private boolean repeat[]; // [Sun, Mon, Tue, Wed, Thu, Fri, Sat]
	
	public Trip(String start, int startWoeid, String dest, int destWoeid, 
			Calendar arrivetime, Calendar commutetime, boolean repeat[]) {
		this.start = start;
		this.startWoeid = startWoeid;
		this.dest = dest;
		this.destWoeid = destWoeid;
		this.arrivetime = (Calendar) arrivetime.clone();
		this.commutetime = (Calendar) commutetime.clone();
		this.repeat = new boolean[7];
		System.arraycopy(repeat, 0, this.repeat, 0, repeat.length);
	}

	public String getStart() {
		return start;
	}

	public String getDest() {
		return dest;
	}
	
	public String getLeaveTime() {
		SimpleDateFormat sdfmt = new SimpleDateFormat("h:mm a");
		Calendar leavetime = (Calendar) arrivetime.clone();
		leavetime.add(Calendar.HOUR, -commutetime.get(Calendar.HOUR));
		leavetime.add(Calendar.MINUTE, -commutetime.get(Calendar.MINUTE));
		return sdfmt.format(leavetime.getTime());
	}
	
	public String getArriveTime() {
		SimpleDateFormat sdfmt = new SimpleDateFormat("h:mm a");
		return (sdfmt.format(arrivetime.getTime()));
	}
	
	public boolean[] getRepeat() {
		return repeat;
	}
	
	public int getStartWoeid() {
		return startWoeid;
	}
	
	public int getDestWoeid() {
		return destWoeid;
	}
}
