package Hosptial;
import java.util.ArrayList;
import java.util.List;
public class Ward {
	    private int wardId;
	    private String wardName;
	    private List<Bed> beds;

	    public Ward(int wardId, String wardName) {
	        this.wardId = wardId;
	        this.wardName = wardName;
	        this.beds = new ArrayList<>();
	    }

	    public Ward(DbConnection dbConnection) {
			// TODO Auto-generated constructor stub
		}

		public int getWardId() {
	        return wardId;
	    }

	    public String getWardName() {
	        return wardName;
	    }

	    public List<Bed> getBeds() {
	        return beds;
	    }

	    public void addBed(Bed bed) {
	        beds.add(bed);
	    }

		public void allocateBed() {
			// TODO Auto-generated method stub
			
		}

	}



