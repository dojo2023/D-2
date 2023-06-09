package model;
import java.io.Serializable;
public class Remark implements Serializable{
    private int    remark_id;
    private String community_id;
    private String user_id;
    private String remark_text;
    private String remark_date;

        public Remark(int remark_id, String community_id, String user_id, String remark_text, String remark_date) {
		super();
		this.remark_id = remark_id;
		this.community_id = community_id;
		this.user_id = user_id;
		this.remark_text = remark_text;
		this.remark_date = remark_date;
		}

		public Remark() {
			super();
			this.remark_id =0;
			this.community_id = "";
			this.user_id = "";
			this.remark_text = "";
			this.remark_date ="";
	}

        public int getRemark_id() {
			return remark_id;
		}

		public void setRemark_id(int remark_id) {
			this.remark_id = remark_id;
		}

         public String getCommunity_id() {
			return community_id;
		}

		public void setCommunity_id(String community_id) {
			this.community_id = community_id;
		}

         public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

         public String getRemark_text() {
			return remark_text;
		}

		public void setRemark_text(String remark_text) {
			this.remark_text = remark_text;
		}

         public String getRemark_date() {
			return remark_date;
		}

		public void setRemark_date(String remark_date) {
			this.remark_date = remark_date;
		}
}
